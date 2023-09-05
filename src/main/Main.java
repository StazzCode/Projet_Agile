package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        int x = 4;
        int y = 9;
        int x2 = x + 1;

        Pizza p = new Pizza("Quatre Fromages");

        ArrayList<Aliments> inventaire = new ArrayList<Aliments>();
        inventaire.add(p);

        Character c = new Character(x, y,inventaire);
        Client client = new Client(x2,y);
        Carte carte = new Carte(c);

        carte.getClientsList().add(client);

        carte.initCarte();
        carte.getGrid()[c.getX()][c.getY()] = c;
        carte.getGrid()[client.getX()][client.getY()] = client;
        carte.displayCarte();

        /*
        Scanner sc = new Scanner(System.in);
        String chaine;
        boolean transi = true;
        while (transi) {
            chaine = sc.nextLine();
            if (chaine.equals(c.getZ())){

            }
        }
        */

        System.out.println();
        System.out.println("Donner une pizza : " + inventaire.get(0).getName() + " | Appuyez sur Entrer");

        Scanner sc = new Scanner(System.in);
        String chaine;
        boolean action = false;
        while (!action) {
            chaine = sc.nextLine();
            if (chaine.equals(""));
            action = true;
        }

        System.out.println();
        System.out.println("Bravo votre client est satisfait !");

    } 
}
