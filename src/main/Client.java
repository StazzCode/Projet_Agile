package main;

import java.util.ArrayList;

public class Client extends Entite {
    
    private int x;
    private int y;
    private char c= 'C';
    private ArrayList<String> inventaire;

    public Client(int x, int y, ArrayList<String> inventaire){
        super(x,y,inventaire);
    }

    public Client(int x, int y){
        this(x, y, null);
    }

    public char getC() {
        return c;
    }
}
