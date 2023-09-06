package test;
    
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Character;
import main.Empty;
import main.InvalidDeplacement;
import main.Aliments;
import main.Carte;

public class CharacterTest {
    public Character perso;
    public Aliments chorizzo = Aliments.CHORIZZO;
    public Carte carte;
    
    @BeforeEach
    public void initialization(){
        this.perso = new Character(2,2);
        this.perso.getInventaire().add(chorizzo);
        this.carte = new Carte(perso);
        this.carte.getGrid()[perso.getY()][perso.getX()] = perso;
    }

    @Test
    public void moveUpTest(){
        try{
            perso.moveUp(carte.getGrid());        
        }catch(InvalidDeplacement e){
            System.out.println("Déplacement vers le haut invalide");
        }
        assertEquals(1, perso.getY());
    }

    @Test
    public void moveDownTest(){
        try{
            perso.moveDown(carte.getGrid());
        } catch (InvalidDeplacement e) {
            System.out.println("Déplacement vers le bas invalide");
        }
        assertEquals(3, perso.getY());
    }

    @Test
    public void moveLeftTest(){
        try{
            perso.moveLeft(carte.getGrid());
        } catch (InvalidDeplacement e) {
            System.out.println("Déplacement vers la gauche invalide");
        }
        assertEquals(1, perso.getX());
    }

    @Test
    public void moveRightTest(){
        try{
            perso.moveRight(carte.getGrid());
        } catch (InvalidDeplacement e) {
            System.out.println("Déplacement vers la droite invalide");
        }
        assertEquals(3, perso.getX());
    }

    @Test
    public void inventaireTest(){
        String chaine =  perso.inventaireToString();
        String res = "Chorizo x1 | ";
        assertEquals(res, chaine);
    }
}
