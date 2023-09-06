package main;

import java.util.ArrayList;
public class Meuble extends Entite{

    private String symbole;
    private String type = null;

    public Meuble(int x, int y , String c){
        super(x,y);
        this.symbole = c;
    }

    public Meuble(int x, int y , String c, String type){
        super(x,y);
        this.symbole = c;
        this.type = type;
    }

    public int getX(){
        return super.getX();
    }

    public int getY(){
        return super.getY();
    }

    public ArrayList<Aliments> getInventaire(){
        return super.getInventaire();
    }

    public String getC(){
        return this.symbole;
    }

     public String getType(){
        return this.type;
    }

    public boolean isMeuble(){
        return true;
    }

    public boolean isClient(){
        return false;
    }

    public String getSymbole() {
        return symbole;
    }

    public ArrayList<Aliments> getIng(){
        ArrayList<Aliments> mesIngredient = new ArrayList<Aliments>();
        Aliments[] ingredients = Aliments.values();
        for (Aliments ing : ingredients) {
            if(ing.getType() == this.type){
                mesIngredient.add(ing);
            }
        }
        return mesIngredient;
    }

    public ArrayList<Pizza> getPiz(ArrayList<Aliments> inventaire){   
        ArrayList<Pizza> lesPizzas = new ArrayList<Pizza>();
        Pizza[] pizzas = Pizza.values(); 
        for (Pizza piz : pizzas) {
                lesPizzas.add(piz);
        }
        return lesPizzas;
    }
}
