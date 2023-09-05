package main;

import java.util.ArrayList;

public class Empty extends Entite{
    
    private int x;
    private int y;
    private char c= ' ';
    private ArrayList<Aliments> inventaire;

    public Empty(int x, int y) {
        super(x, y, null);
    }
}