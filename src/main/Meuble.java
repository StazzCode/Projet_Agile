package main;

import java.util.ArrayList;

public class Meuble extends Entite{
    
    private char symbole;

    public Meuble(int x,int y,char c){
        super(x, y);
        this.symbole = c;
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

    public char getC(){
        return this.symbole;
    }

    public boolean isMeuble(){
        return true;
    }
}
