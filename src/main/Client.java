package main;

import java.util.ArrayList;

public class Client extends Entite {
    
    private int x;
    private int y;
    private String c= "👩";
    private ArrayList<Aliments> inventaire;

    public Client(int x, int y, ArrayList<Aliments> inventaire){
        super(x,y,inventaire);
    }

    public Client(int x, int y){
        this(x, y, null);
    }

    public String getC() {
        return c;
    }
}
