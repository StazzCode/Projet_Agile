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
            Scanner sc1 = new Scanner(file);
            while(sc1.hasNextLine()){
                result = result + sc1.nextLine()+"\n";
            }
            sc1.close();
        }catch(FileNotFoundException e){
            result = result + "ASCII introuvable";
        }
        System.out.println(result);
        Scanner sc2 = new Scanner(System.in);
        int choix = 3;
        try{
            String choixS = sc2.nextLine();
            choix = Integer.parseInt(choixS);
            if(choix == 1 || choix == 2 || choix == 3){
                
            }else{
                System.out.println("Choix impossible !");
                choix = 0;
            }
        }catch(NumberFormatException e){}
        return choix;
    }

    //-------------FIN AFFICHAGE MENU TEXT---------------
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        while(choice == 0){
            choice = afficherMenuPrincipal() ;
        }
        if(choice == 1){
            int x = 9;
        int y = 4;
        int y2 = y + 1;

        Character c = new Character(x, y);
        
        Client client = new Client(x,y2);
        Carte carte = new Carte(c);

        carte.getClientsList().add(client);

        carte.initCarte();
        carte.getGrid()[c.getY()][c.getX()] = c;
        carte.getGrid()[client.getY()][client.getX()] = client;
        carte.displayCarte();
        
        String chaine;
        boolean transi = true;
        while (transi) {
            chaine = sc.nextLine();
            System.out.println(CLEARSCREEN);
            if (chaine.equals(c.getZ())){
                try{
                    c.moveUp();
                    carte.getGrid()[c.getY() + 1][c.getX()] = new Empty(c.getY() + 1, c.getX()) ;
                    carte.getGrid()[c.getY()][c.getX()] = c ;
                }catch(InvalidDeplacement e){
                    System.out.println("Déplacement vers le haut invalide");
                }
            }else if (chaine.equals(c.getS())){
                try {
                    c.moveDown();
                    carte.getGrid()[c.getY() - 1][c.getX()] = new Empty(c.getY() - 1, c.getX()) ;
                    carte.getGrid()[c.getY()][c.getX()] = c ;
                } catch (InvalidDeplacement e) {
                    // TODO: handle exception
                    System.out.println("Déplacement vers le bas invalide");
                }
            }else if (chaine.equals(c.getQ())){
                try {
                    c.moveLeft();
                    carte.getGrid()[c.getY()][c.getX() + 1] = new Empty(c.getY(), c.getX() + 1) ;
                    carte.getGrid()[c.getY()][c.getX()] = c ;
                } catch (InvalidDeplacement e) {
                    // TODO: handle exception
                    System.out.println("Déplacement vers la gauche invalide");
                }
            }else if (chaine.equals(c.getD())){
                try {
                    c.moveRight();
                    carte.getGrid()[c.getY()][c.getX() - 1] = new Empty(c.getY(), c.getX() - 1) ;
                    carte.getGrid()[c.getY()][c.getX()] = c ;
                    
                } catch (InvalidDeplacement e) {
                    // TODO: handle exception
                    System.out.println("Déplacement vers la droite invalide");
                }
            }else{
                transi = false;
            }
            carte.displayCarte();

            }
        }
    }

    public static void demoAlimentsInventaire(Character c,Scanner sc){
        Pizza pizz1 = Pizza.SPICY_TEXAS;
            Pizza pizz2 = Pizza.SPICY_TEXAS;

            c.addToInventaire(Aliments.BOEAUF);
            c.addToInventaire(Aliments.MOZZARELLA);
            c.addToInventaire(Aliments.CHORIZZO);
            c.addToInventaire(Aliments.BOEAUF);

            System.out.println();
            System.out.println("Ton inventaire :" + c.inventaireToString() + "");
            System.out.println("Donner une pizza : " + pizz1.getName() + " | Appuyez sur Entrer");

            String mChaine;
            boolean action = false;
            while (!action) {
                mChaine = sc.nextLine();
                if(pizz1.verifPizza(c.getInventaire())){ 
                    System.out.println("Bravo votre client est satisfait !");
                    action = true;
                }else{
                    System.out.println("Vous n'avez pas les ingredients necessaire");
                }
            }

            System.out.println();
            System.out.println("Ton inventaire :" + c.inventaireToString() + "");
            System.out.println("Donner une pizza : " + pizz2.getName() + " | Appuyez sur Entrer");

            
            action = false;
            while (!action) {
                mChaine = sc.nextLine();
                if(pizz2.verifPizza(c.getInventaire())){
                    action = true;
                }else{
                    System.out.println("Vous n'avez pas les ingredients necessaire");
                }
            }
            System.out.println();
            } 
    }

    

