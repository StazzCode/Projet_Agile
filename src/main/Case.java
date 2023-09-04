package main;
public abstract class Case{

    private boolean traversable;

    public Case(boolean tr){
        this.traversable = tr;
    }

    public abstract String getName();

}