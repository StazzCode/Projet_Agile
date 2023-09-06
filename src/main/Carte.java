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
                    carte[i][j] = new Mur(false, "|");
                }else if(i == 0 || i == 9){
                    carte[i][j] = new Mur(false, "-");
                }else{
                    carte[i][j] = new Mur(true, " ");
                }
                this.grid[i][j] = new Empty(i, j);
            }
        }
        this.grid[1][1] = new Meuble(1, 1, 'F', "viande");
        this.grid[1][3] = new Meuble(1, 3, 'F', "fromage");
        this.grid[1][5] = new Meuble(1, 5, 'F', "sauce");
        this.grid[1][7] = new Meuble(1, 7, 'F', "legume");
        this.grid[1][9] = new Meuble(1, 7, 'F', "plant");
         this.grid[1][15] = new Meuble(1, 7, 'H');
    }

    public void displayCarte(){
        for(int i = 0;i < carte.length;i ++){
            for(int j = 0; j < carte[i].length;j++){
                if (grid[i][j] == a){
                    System.out.print(a.getC());
                }else if (clientsList.contains(grid[i][j]) || this.grid[i][j].isMeuble()){
                    System.out.print(grid[i][j].getC());
                }else{
                    System.out.print(carte[i][j].getName());
                }
                
            }
            System.out.println();
            
        }
        System.out.println();
        System.out.println("\n|-------------------------------------------------------------------------------------|");
            System.out.println("|0. Spicy Texas : - Boeauf , Chorizzo , Mozarella $ score: 300                        |");
            System.out.println("|-------------------------------------------------------------------------------------|");
            System.out.println("|1. Original Bacon : - Bacon , Boeauf , Mozarella , Oignon $ score: 400               |");
            System.out.println("|-------------------------------------------------------------------------------------|");
            System.out.println("|2. Margarita : - Mozarella , Basilic , Boeauf $ score: 200                           |");
            System.out.println("|-------------------------------------------------------------------------------------|");
            System.out.println("|3. Extra Hot : - Piments , Poulet , Oignon , Chorizzo $ score: 500                   |");
            System.out.println("|-------------------------------------------------------------------------------------|");
            System.out.println("|4. Special Papa : - Poulet , Bacon , Chorizzo , Basilic , Sauce Secrete $ score: 800 |");
            System.out.println("|-------------------------------------------------------------------------------------|\n\n");
    }

    public ArrayList<Client> getClientsList() {
        return clientsList;
    }
}