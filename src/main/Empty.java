package main;

import java.util.ArrayList;

public class Empty extends Entite{
    
    private char c= ' ';

    public Empty(int x, int y,char c) {
        super(x, y);
        this.c = c;
    }

    public Empty(int x, int y) {
        super(x, y);
    }

    public char getC(){
        return this.c;
    }

    public boolean isMeuble(){
        return false;
    }
}