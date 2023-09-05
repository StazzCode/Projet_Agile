package main;

import java.util.ArrayList;

public class Character extends Entite{

    private final String Z = "Z";
    private final String Q = "Q";
    private final String S = "S";
    private final String D = "D";
 
    private int x;
    private int y;
    private char c= 'P';
    private ArrayList<Aliments> inventaire;

    public Character(int x, int y, ArrayList<Aliments> inventaire){
        super(x, y, inventaire);
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

    public Character(int x, int y){
        this(x, y, null);
    }

    public char getC() {
        return c;
    }

    public void moveUp(){
        this.setY(this.getY()-1);
    }

    public void moveDown(){
        this.setY(this.getY()+1);
    }

    public void moveLeft(){
        this.setX(this.getX()-1);
    }

    public void moveRight(){
        this.setX(this.getX()+1);
    }

    public ArrayList<Aliments> getInventaire() {
        return inventaire;
    }
}