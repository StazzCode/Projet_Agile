package main;

public class Character {

    private int x = 5;
    private int y = 5;
    private char c= 'P';
    private String[] inventaire;

    public Character(int x, int y, String[] inventaire){
        this.x = x;
        this.y = y;
        this.inventaire = inventaire;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setC(char c) {
        this.c = c;
    }

    public char getC() {
        return c;
    }

    public void moveUp(){
        this.x = getX() - 1;
    }

    public void moveDown(){
        this.x = getX() + 1;
    }

    public void moveLeft(){
        this.y = getY() - 1;
    }

    public void moveRight(){
        this.y = getY() + 1;
    }
}