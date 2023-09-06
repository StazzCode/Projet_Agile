package main;

import java.util.ArrayList;

    String name;

    public Meuble(boolean tr,String name){
        super(tr);
        this.name = name;
    }

    public ArrayList<Aliments> getInventaire(){
        return super.getInventaire();
    }

    public char getC(){
        return this.symbole;
    }

    public boolean isMeuble(){
        return true;
    }
}
