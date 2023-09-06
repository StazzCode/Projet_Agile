package main;

import java.util.ArrayList;

public enum Pizza{

    SPICY_TEXAS("spicy texas", Aliments.BOEAUF, Aliments.CHORIZZO, Aliments.MOZZARELLA, null, null, 300),
    ORIGINAL_BACON("original bacon", Aliments.BACON, Aliments.BOEAUF, Aliments.MOZZARELLA, Aliments.OIGNONS, null, 400),
    MARGARITA("margarita", Aliments.MOZZARELLA , Aliments.BASILIC , Aliments.BOEAUF,null,null, 200),
    EXTRA_HOT("extra hot",Aliments.PIMENTS_JALAPENOS , Aliments.POULET , Aliments.OIGNONS , Aliments.CHORIZZO , null, 500),
    SPECIAL_PAPA("special papa",Aliments.POULET, Aliments.BACON , Aliments.CHORIZZO , Aliments.BASILIC , Aliments.SAUCE_SECRETE, 800);

    private String name;
    private ArrayList<Aliments> AlimentsList = new ArrayList<Aliments>();
    private int score;

    private Pizza(String name, Aliments alim1, Aliments alim2, Aliments alim3, Aliments alim4, Aliments alim5, int score){
        this.name = name;
        this.AlimentsList.add(alim1);
        this.AlimentsList.add(alim2);
        this.AlimentsList.add(alim3);
        this.AlimentsList.add(alim4);
        this.AlimentsList.add(alim5);
        this.score = score;
    }

    public String getName(){
        return this.name;
    }

    public int getScore() {
        return score;
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
        return isGood;
    }
}