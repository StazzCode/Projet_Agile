package main;

import java.util.ArrayList;
import java.lang.Character.*;

public class Character extends Entite{

    private final String Z = "Z";
    private final String Q = "Q";
    private final String S = "S";
    private final String D = "D";

    private final String E = "E";
 

    private String name = "";
    private int score = 0;
    private int x;
    private int y;
    private String c= (char)27 + "[33m" + "\u25C9" + (char)27 + "[39m";
    private ArrayList<Aliments> inventaire;
    private ArrayList<Pizza> inventairePizza;

    public Character(int x, int y){
        super(x, y);
        this.inventairePizza = new ArrayList<Pizza>();
        this.inventaire = new ArrayList<Aliments>();
    }

    public boolean isMeuble(){
        return false;
    }

    public String getE() {
        return E;
    }

    public boolean isClient(){
        return false;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return this.score;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ArrayList<Pizza> getInventairePizza() {
        return this.inventairePizza;
    }

    public void addToInventaire(Aliments aliment){
        this.inventaire.add(aliment);
    }

    public String getZ() {
        return Z;
    }

    public String getQ() {
        return Q;
    }

    public String getS() {
        return S;
    } 

    public String getD() {
        return D;
    }

    public ArrayList<Aliments> getInventaire() {
        return this.inventaire;
    }

    public String getC() {
        return c;
    }

    public void moveUp(Entite[][] grid) throws InvalidDeplacement{
        if(this.getY()-1<=0) throw new InvalidDeplacement("Déplacement vers le haut invalide");
        if(grid[this.getY()-1][this.getX()] != null){
            if(grid[this.getY()-1][this.getX()].isMeuble()) throw new InvalidDeplacement("Attention au Meuble");
            if(grid[this.getY()-1][this.getX()].isClient()) throw new InvalidDeplacement("Attention au client");
        }
            
        this.setY(this.getY()-1);
    }


    public void moveDown(Entite[][] grid)throws InvalidDeplacement{
        if(this.getY()+1>=9) throw new InvalidDeplacement("Déplacement vers le bas invalide");
        if(grid[this.getY()-1][this.getX()] != null){
            if(grid[this.getY()+1][this.getX()].isMeuble()) throw new InvalidDeplacement("Attention au Meuble");
            if(grid[this.getY()+1][this.getX()].isClient()) throw new InvalidDeplacement("Attention au client");
        }
        this.setY(this.getY()+1);
    }

    public void moveLeft(Entite[][] grid)throws InvalidDeplacement{
        if(this.getX()-1<=0) throw new InvalidDeplacement("Déplacement vers la gauche invalide");
        if(grid[this.getY()-1][this.getX()] != null){
            if(grid[this.getY()][this.getX()-1].isMeuble()) throw new InvalidDeplacement("Attention au Meuble");
            if(grid[this.getY()][this.getX()-1].isClient()) throw new InvalidDeplacement("Attention au client");
        }
        this.setX(this.getX()-1);
    }

    public void moveRight(Entite[][] grid)throws InvalidDeplacement{
        if(this.getX()+1>=19) throw new InvalidDeplacement("Déplacement vers la droite invalide");
        if(grid[this.getY()-1][this.getX()] != null){
            if(grid[this.getY()][this.getX()+1].isMeuble()) throw new InvalidDeplacement("Attention au Meuble");
            if(grid[this.getY()][this.getX()+1].isClient()) throw new InvalidDeplacement("Attention au client");
        }
        this.setX(this.getX()+1);
    }

    public String inventaireToString() {
        String res = "";
        ArrayList<Aliments> alim = new ArrayList<Aliments>();
        for(int i = 0; i < getInventaire().size(); i++){
            if(!alim.contains(getInventaire().get(i))){
                res += getInventaire().get(i).getName();
                alim.add(getInventaire().get(i));
                int nb = 0;
                boolean many = false;
                for(int j = i; j < getInventaire().size(); j++){    
                    if(getInventaire().get(j) == getInventaire().get(i)){
                        nb += 1;
                        if(many == true){
                            res = res.substring(0, res.length() - 3);
                        }
                        res += " x" + nb;
                        many = true;
                    }
                }
                res += " | ";
            }
            
        }
        return res;
    }

    public void addToInventairePizza(Pizza pizza){
        if(pizza.verifPizza(this.inventaire)){
            this.inventairePizza.add(pizza);
            this.inventaire.clear();
        }else{
            System.out.println("il te manque des ingredinent MAMAAAAA !! ");
        }
    }
}