package main;

import java.util.ArrayList;

public class Carte{

    private Character a;
    private ArrayList<Client> clientsList = new ArrayList<Client>();

    private Case[][] carte = new Case[10][20];

    private Entite[][] grid = new Entite[10][20];

    public Carte(Character a){
        this.a = a;
    }

    public Character getA() {
        return a;
    }

    public Case[][] getCarte() {
        return carte;
    }

    public Entite[][] getGrid() {
        return grid;
    }

    public void initCarte(){
        for(int i = 0;i < carte.length;i ++){
            for(int j = 0; j < carte[i].length;j++){
                if(j == 0||j == 19){
                    carte[i][j] = new Meuble(false, "X");
                }else if(i == 0 || i == 9){
                    carte[i][j] = new Meuble(false, "Y");
                }else{
                    carte[i][j] = new Meuble(true, " ");
                }
            }
        }
    }

    public void displayCarte(){
        for(int i = 0;i < carte.length;i ++){
            for(int j = 0; j < carte[i].length;j++){
                if (grid[i][j] == a){
                    System.out.print(a.getC());
                }else if (clientsList.contains(grid[i][j])){
                    System.out.print(grid[i][j].getC());
                }else{
                    System.out.print(carte[i][j].getName());
                }
                
            }
            System.out.println();
        }
    }

    public ArrayList<Client> getClientsList() {
        return clientsList;
    }
}