package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.Scanner;
import java.lang.*;

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
        
        int score = 0;

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

        Carte carte = new Carte(c);

        carte.getClientsList().add(new Client(2,6));
        carte.getClientsList().add(new Client(5,6));
        carte.getClientsList().add(new Client(8,6));
        carte.getClientsList().add(new Client(11,6));
        carte.getClientsList().add(new Client(14,6));
        carte.getClientsList().add(new Client(17,6));

        carte.getClientsList().add(new Client(3,8));
        carte.getClientsList().add(new Client(6,8));
        carte.getClientsList().add(new Client(9,8));
        carte.getClientsList().add(new Client(12,8));
        carte.getClientsList().add(new Client(15,8));

        carte.initCarte();
        carte.getGrid()[c.getY()][c.getX()] = c;

        for(int i = 0; i < carte.getClientsList().size(); i++){
            carte.getGrid()[carte.getClientsList().get(i).getY()][carte.getClientsList().get(i).getX()] = carte.getClientsList().get(i);
        }
        carte.displayCarte();
        
        String chaine;
        boolean transi = true;
        LocalTime begin = LocalTime.now();
        LocalTime end = begin.plusMinutes(3);
        //LocalTime end = begin.plusSeconds(3);
        while (transi && begin.isBefore(end)) {
            if (isNearClient(c, carte.getGrid()) != null){
                System.out.println("Donner la commande du Client : " + isNearClient(c, carte.getGrid()).getCommande());
            }
            if(isNearMeuble(c, carte.getGrid()) != null && isNearMeuble(c, carte.getGrid()).getType() != null){
                System.out.println("contenu du frigo : ");
                for(int i = 0; i < isNearMeuble(c, carte.getGrid()).getIng().size(); i++){
                    System.out.print(i + "." + isNearMeuble(c, carte.getGrid()).getIng().get(i) + " ");
                }

                System.out.println("quel est le chiffre de l'ingredient que tu souhaite?");

                chaine = sc.nextLine();
                chaine = chaine.toUpperCase();

                try {
                    if(Integer.parseInt(chaine) >= 0 && Integer.parseInt(chaine) <= isNearMeuble(c, carte.getGrid()).getIng().size()){
                        Aliments alimChoice = isNearMeuble(c, carte.getGrid()).getIng().get(Integer.parseInt(chaine));
                        System.out.println("Combien en veux tu?");
                        chaine = sc.nextLine();
                        chaine = chaine.toUpperCase();
                        if(Integer.parseInt(chaine) >=0){
                            for(int i = 0; i < Integer.parseInt(chaine); i++){
                                c.addToInventaire(alimChoice);
                            }
                        }
                    }
                } catch (NumberFormatException e) {}
            }
            if(isNearMeuble(c, carte.getGrid()) != null && isNearMeuble(c, carte.getGrid()).getType() == null){
                if(isNearMeuble(c, carte.getGrid()).getPiz(c.getInventaire()).size() > 0){
                    System.out.println("Quel Pizza souhaite tu fabriquer:" + isNearMeuble(c, carte.getGrid()).getPiz(c.getInventaire()).size());

                    chaine = sc.nextLine();
                    chaine = chaine.toUpperCase();
                    try{
                        c.addToInventairePizza(isNearMeuble(c, carte.getGrid()).getPiz(c.getInventaire()).get(Integer.parseInt(chaine)));
                        
                    }catch (NumberFormatException e) {}
                }else{
                     System.out.println("Vous n'avez pas assez d'ingredients");
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
                    carte.getGrid()[c.getY()][c.getX()] = c;
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
                    carte.getGrid()[c.getY()][c.getX()] = c;
                } catch (InvalidDeplacement e) {
                    System.out.println("Déplacement vers la droite invalide");
                }
            }else if(chaine.equals("X")){
                transi = false;
                System.out.println();
                System.out.println("Le jeu est terminé.");
                System.out.println();
                System.out.println("Votre score final est : " + score + " points");
                System.out.println();
                System.out.println("Au revoir !");
            }
            else if(chaine.equals(c.getE()) && isNearClient(c, carte.getGrid()) != null){
                System.out.println(c.getInventairePizza() + " " + isNearClient(c, carte.getGrid()).getCommande());
                if(c.getInventairePizza().contains(isNearClient(c, carte.getGrid()).getCommande())){
                    c.getInventairePizza().remove(isNearClient(c, carte.getGrid()).getCommande());
                    isNearClient(c, carte.getGrid()).getInventairePizza().add(isNearClient(c, carte.getGrid()).getCommande());

                    score += isNearClient(c, carte.getGrid()).getCommande().getScore();
                    isNearClient(c, carte.getGrid()).setCommande();

                    System.out.println("Bravo le Client est satisfait !");
                }else{
                    System.out.println("Vous n'avez pas la bonne pizza !");
                }
            }else{
                System.out.println("Saisie invalide");
            }
            if (end.isBefore(begin)){
                System.out.println();
                System.out.println("Le jeu est terminé.");
                System.out.println();
                System.out.println("Votre score final est : " + score + " points");
                System.out.println();
                System.out.println("Au revoir !");
            }
            carte.displayCarte();
            System.out.println("Tes ingredients :" + c.inventaireToString()  + "");
            System.out.println("Tes Pizza :" + c.getInventairePizza()  + "");
            System.out.println("Ton Score :" + score  + "");
            }
            
        }else if(choice == 2){
            demoAlimentsInventaire(c, sc);
        }
    }

    public static void demoAlimentsInventaire(Character c,Scanner sc){

        Client client = new Client(2, 2);
        
        c.addToInventaire(Aliments.BOEAUF);
        c.addToInventaire(Aliments.MOZZARELLA);
        c.addToInventaire(Aliments.CHORIZZO);
        c.addToInventaire(Aliments.BOEAUF);

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
    
    

    public static Client isNearClient (Character c, Entite[][] grid){
        Client near = null;
        int xC=c.getX();
        int yC=c.getY();
        if(grid[yC-1][xC].isClient()){
            near = (Client) grid[yC-1][xC];
        }else if(grid[yC+1][xC].isClient()){
            near = (Client) grid[yC+1][xC];
        }else if(grid[yC][xC-1].isClient()){
            near = (Client) grid[yC][xC-1];
        }else if(grid[yC][xC+1].isClient()){
            near = (Client) grid[yC][xC+1];
        }
        return near;
    }

     public static Meuble isNearMeuble (Character c, Entite[][] grid){
        Meuble near = null;
        int xC=c.getX();
        int yC=c.getY();
        if(grid[yC-1][xC].isMeuble()){
            near = (Meuble) grid[yC-1][xC];
        }else if(grid[yC+1][xC].isMeuble()){
            near = (Meuble) grid[yC+1][xC];
        }else if(grid[yC][xC-1].isMeuble()){
            near = (Meuble) grid[yC][xC-1];
        }else if(grid[yC][xC+1].isMeuble()){
            near = (Meuble) grid[yC][xC+1];
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
    

