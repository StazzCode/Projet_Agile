package main;

import java.util.ArrayList;

public abstract class Entite {
    
    private int x;
    private int y;
    private String c;
    private ArrayList<Aliments> inventaire;

    public Entite(int x, int y) {
        this.x = x;
        this.y = y;
        this.inventaire = new ArrayList<Aliments>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setC(String c) {
        this.c = c;
    }
    public abstract char getC();

    public abstract boolean isMeuble();

    public abstract boolean isClient();

    public ArrayList<Aliments> getInventaire(){
        return this.inventaire;
    } 


    public void addToInventaire(Aliments aliment){
        this.inventaire.add(aliment);
    }
}
