package main;
public class Mur extends Case{

    String name;

    public Mur(boolean tr,String name){
        super(tr);
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    
}