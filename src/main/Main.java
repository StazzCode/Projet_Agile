package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        int x = 9;
        int y = 4;
        int y2 = y + 1;

        ArrayList<Aliments> inventaire = new ArrayList<Aliments>();
        inventaire.add(Aliments.BOEAUF);

        Character c = new Character(x, y, inventaire);
        Client client = new Client(x,y2);
        Carte carte = new Carte(c);

        carte.getClientsList().add(client);

        carte.initCarte();
        carte.getGrid()[c.getY()][c.getX()] = c;
        carte.getGrid()[client.getY()][client.getX()] = client;
        carte.displayCarte();

        
        Scanner sc = new Scanner(System.in);
        String chaine;
        boolean transi = true;
        while (transi) {
            chaine = sc.nextLine();
            if (chaine.equals(c.getZ())){
                try{
                    c.moveUp();
                    carte.getGrid()[c.getY() + 1][c.getX()] = new Empty(c.getY() + 1, c.getX()) ;
                    carte.getGrid()[c.getY()][c.getX()] = c ;
                }catch(InvalidDeplacement e){
                    System.out.println("Déplacement vers le haut invalide");
                }
            }else if (chaine.equals(c.getS())){
                try {
                    c.moveDown();
                    carte.getGrid()[c.getY() - 1][c.getX()] = new Empty(c.getY() - 1, c.getX()) ;
                    carte.getGrid()[c.getY()][c.getX()] = c ;
                } catch (InvalidDeplacement e) {
                    // TODO: handle exception
                    System.out.println("Déplacement vers le bas invalide");
                }
            }else if (chaine.equals(c.getQ())){
                try {
                    c.moveLeft();
                    carte.getGrid()[c.getY()][c.getX() + 1] = new Empty(c.getY(), c.getX() + 1) ;
                    carte.getGrid()[c.getY()][c.getX()] = c ;
                } catch (InvalidDeplacement e) {
                    // TODO: handle exception
                    System.out.println("Déplacement vers la gauche invalide");
                }
            }else if (chaine.equals(c.getD())){
                try {
                    c.moveRight();
                    carte.getGrid()[c.getY()][c.getX() - 1] = new Empty(c.getY(), c.getX() - 1) ;
                    carte.getGrid()[c.getY()][c.getX()] = c ;
                    
                } catch (InvalidDeplacement e) {
                    // TODO: handle exception
                    System.out.println("Déplacement vers la droite invalide");
                }
            }else{
                transi = false;
            }
            carte.displayCarte();
        }
        

        /*
        System.out.println();
        System.out.println("Donner une pizza : " + inventaire.get(0).getName() + " | Appuyez sur Entrer");

        Scanner sc = new Scanner(System.in);
        String chaine;
        boolean action = false;
        while (!action) {
            chaine = sc.nextLine();
            if (chaine.equals(""));
            action = true;
        }

        System.out.println();
        System.out.println("Bravo votre client est satisfait !");
        */
    } 
}
