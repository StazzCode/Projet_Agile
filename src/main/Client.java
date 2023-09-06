package main;

import java.util.ArrayList;

public class Client extends Entite {
    
    private int x;
    private int y;
    private char c= 'C';
    private ArrayList<Aliments> inventaire;

    public Client(int x, int y){
        super(x,y);
    }

    public char getC() {
        return c;
    }

    public boolean isMeuble(){
        return false;
    }
    public boolean isClient(){
        return true;
    }
}
