package main;

import java.util.ArrayList;

public enum Pizza{

    SPICY_TEXAS("spicy texas", Aliments.BOEAUF, Aliments.CHORIZZO, Aliments.MOZZARELLA, null, null);

    private String name;
    private ArrayList<Aliments> AlimentsList = new ArrayList<Aliments>();

    private Pizza(String name, Aliments alim1, Aliments alim2, Aliments alim3, Aliments alim4, Aliments alim5){
        this.name = name;
        this.AlimentsList.add(alim1);
        this.AlimentsList.add(alim2);
        this.AlimentsList.add(alim3);
        this.AlimentsList.add(alim4);
        this.AlimentsList.add(alim5);
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Aliments> getAlimentsList(){
        return this.AlimentsList;
    }

    public boolean verifPizza(ArrayList<Aliments> pizzaPerso){
        boolean isGood = true;
        ArrayList<Aliments> ingredients = new ArrayList<Aliments>();
        for(int i = 0; i < this.AlimentsList.size(); i++){
            if(!pizzaPerso.contains(this.AlimentsList.get(i)) && this.AlimentsList.get(i) != null){
                isGood = false;
            }
            ingredients.add(this.AlimentsList.get(i));
        }
        if(isGood == true){
            for(int i =0; i < ingredients.size(); i++){
                pizzaPerso.remove(ingredients.get(i));
            }
        }
        return isGood;
    }
}