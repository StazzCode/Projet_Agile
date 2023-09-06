package main;

import java.util.ArrayList;

public class Client extends Entite {
    
    private int x;
    private int y;
    private String c= "👩";
    private ArrayList<Aliments> inventaire;

    public Client(int x, int y){
        super(x,y);
    }

    public String getC() {
        return c;
    }

    public boolean isMeuble(){
        return false;
    }
}
