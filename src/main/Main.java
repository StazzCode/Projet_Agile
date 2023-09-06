package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public final static String CLEARSCREEN = "\033[H\033[2J";
    //--------------AFFICHAGE MENU TEXT----------------

    public static int afficherMenuPrincipal(){ //renvoi le choix du joueur (1 = jouer 2 = classement 3 = quitter)
        String result = "";
        System.out.println(CLEARSCREEN);
        try{
            FileReader file = new FileReader("res/mainMenuText.txt");
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
        System.out.println(CLEARSCREEN);
        return choix;
    }

    //-------------FIN AFFICHAGE MENU TEXT---------------
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        while(choice == 0){
            choice = afficherMenuPrincipal() ;
        }
        int x = 9;
        int y = 3;
        int y2 = y + 2;
        int x3= x-2;
        int x4 = x+2;
        Character c = new Character(x, y);
        if(choice == 1){      
        
        Client client = new Client(x,y2,Pizza.SPICY_TEXAS);
        Client cliente = new Client(x3,y2,Pizza.ORIGINAL_BACON);
        Client clint = new Client(x4,y2);

        c.getInventairePizza().add(Pizza.SPICY_TEXAS); // Ajoute un pizza dans l'inventaire à Pizza du joueur.

        Carte carte = new Carte(c);

        carte.getClientsList().add(client);
        carte.getClientsList().add(cliente);
        carte.getClientsList().add(clint);

        carte.initCarte();
        carte.getGrid()[c.getY()][c.getX()] = c;
        carte.getGrid()[client.getY()][client.getX()] = client;
        carte.getGrid()[cliente.getY()][cliente.getX()] = cliente;
        carte.getGrid()[clint.getY()][clint.getX()] = clint;
        carte.displayCarte();
        
        String chaine;
        boolean transi = true;
        LocalTime begin = LocalTime.now();
        LocalTime end = begin.plusMinutes(3);
        while (transi && begin.isBefore(end)) {
            if (isNearClient(c, carte.getGrid())){
                /*int xNC = whoIsClient(c, carte.getGrid()).getX();
                int yNC = whoIsClient(c, carte.getGrid()).getY();
                System.out.println(xNC + ", " + yNC);
                Pizza pNC = carte.getGrid()[yNC][xNC].getInventairePizza().get(0); */
                Client clienta = whoIsClient(c,carte.getGrid());
                if(clienta.getX() ==client.getX() && clienta.getY()== client.getY()){
                    System.out.println();
                    System.out.println("Donner la commande du Client : " + client.getCommande());
                }else if(clienta.getX() ==cliente.getX() && clienta.getY()== cliente.getY()){
                    System.out.println();
                    System.out.println("Donner la commande du Client : " + cliente.getCommande());
                }else{
                   System.out.println();
                System.out.println("Donner la commande du Client : " + clint.getCommande()); 
                }
                
            }
            chaine = sc.nextLine();
            chaine = chaine.toUpperCase();

            System.out.println(CLEARSCREEN);
            begin = LocalTime.now();
            if(end.getMinute()-begin.getMinute() < 1){
                System.out.println(end.getSecond() - begin.getSecond()+" seconde(s) restante");
            }else{
               System.out.println(end.getMinute()-begin.getMinute()+" Minute(s) restante\n"); 
            }            
            if (chaine.equals(c.getZ())){
                try{
                    c.moveUp(carte.getGrid());
                    carte.getGrid()[c.getY() + 1][c.getX()] = new Empty(c.getY() + 1, c.getX()) ;
                    carte.getGrid()[c.getY()][c.getX()] = c ;
                }catch(InvalidDeplacement e){
                    System.out.println("Déplacement vers le haut invalide");
                }
            }else if (chaine.equals(c.getS())){
                try {
                    c.moveDown(carte.getGrid());
                    carte.getGrid()[c.getY() - 1][c.getX()] = new Empty(c.getY() - 1, c.getX()) ;
                    carte.getGrid()[c.getY()][c.getX()] = c ;
                } catch (InvalidDeplacement e) {
                    System.out.println("Déplacement vers le bas invalide");
                }
            }else if (chaine.equals(c.getQ())){
                try {
                    c.moveLeft(carte.getGrid());
                    carte.getGrid()[c.getY()][c.getX() + 1] = new Empty(c.getY(), c.getX() + 1) ;
                    carte.getGrid()[c.getY()][c.getX()] = c;
                } catch (InvalidDeplacement e) {
                    System.out.println("Déplacement vers la gauche invalide");
                }
            }else if (chaine.equals(c.getD())){
                try {
                    c.moveRight(carte.getGrid());
                    carte.getGrid()[c.getY()][c.getX() - 1] = new Empty(c.getY(), c.getX() - 1) ;
                    carte.getGrid()[c.getY()][c.getX()] = c ;
                    
                } catch (InvalidDeplacement e) {
                    System.out.println("Déplacement vers la droite invalide");
                }
            }else if(chaine.equals("X")){
                transi = false;
                System.out.println("Au revoir !");
            }
            else if(chaine.equals(c.getE()) && isNearClient(c, carte.getGrid())){
                if(c.getInventairePizza().contains(client.getCommande())){
                    c.getInventairePizza().remove(client.getCommande());
                    client.getInventairePizza().add(client.getCommande());
                    System.out.println("Bravo le Client est satisfait !");
                }else{
                    System.out.println("Vous n'avez pas la bonne pizza !");
                }
            }else{
                System.out.println("Saisie invalide");
            }
            carte.displayCarte();
            }
        }else if(choice == 2){
            demoAlimentsInventaire(c, sc);
        }
    }

    public static void demoAlimentsInventaire(Character c,Scanner sc){

        c.addToInventaire(Aliments.BOEAUF);
        c.addToInventaire(Aliments.MOZZARELLA);
        c.addToInventaire(Aliments.CHORIZZO);
        c.addToInventaire(Aliments.BOEAUF);

        Client client = new Client(2, 2);

        System.out.println();
        System.out.println("Ton inventaire :" + c.inventaireToString() + "");
        System.out.println("Donner une pizza : " + client.getCommande() + " | Appuyez sur Entrer");

            String mChaine;
            boolean action = false;
            while (!action) {
                mChaine = sc.nextLine();
                if(client.getCommande().verifPizza(c.getInventaire())){ 
                    System.out.println("Bravo votre client est satisfait !");
                    action = true;
                }else{
                    System.out.println("Vous n'avez pas les ingredients necessaire");
                }
            }

            System.out.println();
            System.out.println("Ton inventaire :" + c.inventaireToString() + "");
            System.out.println("Donner une pizza : " + client.getCommande().getName() + " | Appuyez sur Entrer");

            
            action = false;
            while (!action) {
                mChaine = sc.nextLine();
                if(client.getCommande().verifPizza(c.getInventaire())){
                    action = true;
                }else{
                    System.out.println("Vous n'avez pas les ingredients necessaire");
                }
            }
            System.out.println();
        } 
    
    

    public static boolean isNearClient (Character c, Entite[][] grid){
        boolean near = false;
        int xC=c.getX();
        int yC=c.getY();
        if(grid[yC-1][xC].isClient() || grid[yC+1][xC].isClient() || grid[yC][xC-1].isClient()||grid[yC][xC+1].isClient()){
            near=true;
        }

        return near;
    }

    public static Client whoIsClient (Character c, Entite[][] grid){
        boolean near = false;
        int xC=c.getX();
        int yC=c.getY();
        if(grid[yC-1][xC].isClient()){
            return new Client(xC,yC-1);
        }else if(grid[yC+1][xC].isClient()){
            return new Client(xC,yC+1);
        }else if (grid[yC][xC-1].isClient()){
            return new Client(xC-1,yC);
        }else if(grid[yC][xC+1].isClient()){
            return new Client(xC+1,yC);
        }else{
            return new Client(xC,yC);
        }

    }

    public static boolean isPossessingCommand(Character c, Client client){
        boolean possessing=false;
        if(client.getCommande().verifPizza(c.getInventaire())){
            possessing = true;
        }
        return possessing;
    }
}
    

