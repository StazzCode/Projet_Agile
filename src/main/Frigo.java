package main;

import java.util.ArrayList;

public class Frigo extends Meuble{
    
    String type;

    public Frigo(int x, int y , char c, String type){
        super(x, y, c);
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public ArrayList<Aliments>  getIng(){
        ArrayList<Aliments> mesIngredient = new ArrayList<Aliments>();
        Aliments[] ingredients = Aliments.values();
        for (Aliments ing : ingredients) {
            if(ing.getType() == this.type){
                mesIngredient.add(ing);
            }
        }
        return mesIngredient;
    }
}
