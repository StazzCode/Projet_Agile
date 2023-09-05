package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public final static String CLEARSCREEN = "\033[H\033[2J";
    //--------------AFFICHAGE MENU TEXT----------------

    public static int afficherMenuPrincipal(){ //renvoi le choix du joueur (1 = jouer 2 = classement 3 = quitter)
        String result = "";
        System.out.println(CLEARSCREEN);
        try{
            FileReader file = new FileReader("./res/mainMenuText.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                result = result + sc.nextLine()+"\n";
            }
            sc.close();
        }catch(FileNotFoundException e){
            result = result + "ASCII introuvable";
        }
        System.out.println(result);
        Scanner sc2 = new Scanner(System.in);
        int choix = sc2.nextInt();
        sc2.close();
        return choix;
    }

    //-------------FIN AFFICHAGE MENU TEXT---------------
    
    public static void main(String[] args){
        System.out.println(afficherMenuPrincipal());
        int x = 9;
        int y = 4;
        int y2 = y + 1;

        Pizza p = new Pizza("Quatre Fromages");

        ArrayList<Aliments> inventaire = new ArrayList<Aliments>();
        inventaire.add(p);

        Character c = new Character(x, y,inventaire);
        Client client = new Client(x,y2);
        Carte carte = new Carte(c);

        carte.getClientsList().add(client);

        carte.initCarte();
        carte.getGrid()[c.getY()][c.getX()] = c;
        carte.getGrid()[client.getY()][client.getX()] = client;
        carte.displayCarte();

        
        Scanner sc = new Scanner(System.in);
        String chaine;
        boolean transi = true;
        while (transi) {
            chaine = sc.nextLine();
            if (chaine.equals(c.getZ())){
                c.moveUp();
                carte.getGrid()[c.getY() + 1][c.getX()] = new Empty(c.getY() + 1, c.getX()) ;
                carte.getGrid()[c.getY()][c.getX()] = c ;
            }else if (chaine.equals(c.getS())){
                c.moveDown();
                carte.getGrid()[c.getY() - 1][c.getX()] = new Empty(c.getY() - 1, c.getX()) ;
                carte.getGrid()[c.getY()][c.getX()] = c ;
            }else if (chaine.equals(c.getQ())){
                c.moveLeft();
                carte.getGrid()[c.getY()][c.getX() + 1] = new Empty(c.getY(), c.getX() + 1) ;
                carte.getGrid()[c.getY()][c.getX()] = c ;
            }else if (chaine.equals(c.getD())){
                c.moveRight();
                carte.getGrid()[c.getY()][c.getX() - 1] = new Empty(c.getY(), c.getX() - 1) ;
                carte.getGrid()[c.getY()][c.getX()] = c ;
            }else{
                transi = false;
            }
            carte.displayCarte();
        }
        

        /*
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
        */
    } 
}
