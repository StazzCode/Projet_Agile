package main;

import java.util.ArrayList;

public class Empty extends Entite{
    
    private String c= " ";

    public Empty(int x, int y,String c) {
        super(x, y);
        this.c = c;
    }

    public Empty(int x, int y) {
        super(x, y);
    }

    public String getC(){
        return this.c;
    }

    public boolean isMeuble(){
        return false;
    }

    public boolean isClient(){
        return false;
    }
}