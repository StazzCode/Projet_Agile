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
                    carte[i][j] = new Mur(false, "\u2503");
                }else if(i == 0 || i == 9){
                    carte[i][j] = new Mur(false, "\u2501");
                }else{
                    carte[i][j] = new Mur(true, " ");
                }
                carte[0][0] = new Mur(false, "┏");
                carte[0][19] = new Mur(false, "\u2513");
                carte[9][0] = new Mur(false, "\u2517");
                carte[9][19] = new Mur(false, "\u251B");
                this.grid[i][j] = new Empty(i, j);
            }
        }
        this.grid[1][1] = new Meuble(1, 1, (char)27 + "[47m" + "F" + (char)27 + "[49m", "viande");
        this.grid[1][3] = new Meuble(1, 3, (char)27 + "[47m" + "F" + (char)27 + "[49m", "fromage");
        this.grid[1][5] = new Meuble(1, 5, (char)27 + "[47m" + "F" + (char)27 + "[49m", "sauce");
        this.grid[1][7] = new Meuble(1, 7, (char)27 + "[47m" + "F" + (char)27 + "[49m", "legume");
        this.grid[1][9] = new Meuble(1, 7, (char)27 + "[47m" + "F" + (char)27 + "[49m", "plant");
        this.grid[1][15] = new Meuble(1, 7, (char)27 + "[41m" + (char)27 + "[33m" + "H" + (char)27 + "[49m" + (char)27 + "[0m");
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
        System.out.println("\n┌───────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│ 0. Spicy Texas : - Boeuf , Chorizo , Mozzarella                         $ score : 300 │");
            System.out.println("├───────────────────────────────────────────────────────────────────────────────────────┤");
            System.out.println("│ 1. Original Bacon : - Bacon , Boeuf , Mozzarella , Oignon               $ score : 400 │");
            System.out.println("├───────────────────────────────────────────────────────────────────────────────────────┤");
            System.out.println("│ 2. Margarita : - Mozzarella , Basilic , Boeuf                           $ score : 200 │");
            System.out.println("├───────────────────────────────────────────────────────────────────────────────────────┤");
            System.out.println("│ 3. Extra Hot : - Piments , Poulet , Oignon , Chorizo                    $ score : 500 │");
            System.out.println("├───────────────────────────────────────────────────────────────────────────────────────┤");
            System.out.println("│ 4. Special Papa : - Poulet , Bacon , Chorizo , Basilic , Sauce Secrete  $ score : 800 │");
            System.out.println("└───────────────────────────────────────────────────────────────────────────────────────┘\n\n");
    }

    public ArrayList<Client> getClientsList() {
        return clientsList;
    }
}