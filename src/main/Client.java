package main;

import java.util.ArrayList;
import java.util.Random;

public class Client extends Entite {
    
    private int x;
    private int y;
    private char c= 'C';
    private ArrayList<Pizza> inventairePizza;
    private Pizza commande;

    public Client(int x, int y){
        super(x,y);
        Random random = new Random();
        int index = random.nextInt(Pizza.values().length);

        this.commande = Pizza.values()[index];
        this.inventairePizza = new ArrayList<Pizza>();
    }

    public Client(int x, int y, Pizza p){
        this(x, y);
        this.commande = p;
    } 

    public ArrayList<Pizza> getInventairePizza() {
        return inventairePizza;
    }

    public char getC() {
        return c;
    }

    public Pizza getCommande(){
        return this.commande;
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
