package main;

import java.util.ArrayList;

public class Character extends Entite{
 
    private int x;
    private int y;
    private char c= 'P';
    private ArrayList<String> inventaire;

    public Character(int x, int y, ArrayList<String> inventaire){
        super(x, y, inventaire);
    }

    public Character(int x, int y){
        this(x, y, null);
    }

    public char getC() {
        return c;
    }

    public void moveUp(){
        this.x = getX() - 1;
    }

    public void moveDown(){
        this.x = getX() + 1;
    }

    public void moveLeft(){
        this.y = getY() - 1;
    }

    public void moveRight(){
        this.y = getY() + 1;
    }

    public ArrayList<String> getInventaire() {
        return inventaire;
    }
}