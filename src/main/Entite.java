package main;

import java.util.ArrayList;

public class Entite {
    
    private int x;
    private int y;
    private String c;
    private ArrayList<Aliments> inventaire;

    public Entite(int x, int y, ArrayList<Aliments> inventaire) {
        this.x = x;
        this.y = y;
        //this.c = c;
        this.inventaire = inventaire;
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

    public String getC() {
        return c;
    }
}
