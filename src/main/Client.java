package main;

import java.util.ArrayList;
import java.util.Random;

public class Client extends Entite {
    
    private int x;
    private int y;
    private String c= (char)27 + "[34m" + "\u25C9" + (char)27 + "[0m";
    private ArrayList<Pizza> inventairePizza;
    private Pizza commande;

    public Client(int x, int y){
        super(x,y);
        Random random = new Random();
        int index = random.nextInt(Pizza.values().length);

        this.commande = Pizza.values()[index];
        this.inventairePizza = new ArrayList<Pizza>();
    }

    public ArrayList<Pizza> getInventairePizza() {
        return inventairePizza;
    }

    public String getC() {
        return c;
    }

    public Pizza getCommande(){
        return this.commande;
    }

    public void setCommande(){
        Random random = new Random();
        int index = random.nextInt(Pizza.values().length);

        this.commande = Pizza.values()[index];
    }

    public boolean isMeuble(){
        return false;
    }

    public String toStringCommande(){
        return commande.getName();
    }
    
    public boolean isClient(){
        return true;
    }
}
