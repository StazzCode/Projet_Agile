package main;

public class Main {
    
    public static void main(String[] args){
        int x = 4;
        int y = 9;
        int x2 = x + 1;
        Character c = new Character(x, y);
        Client client = new Client(x2,y);
        Carte carte = new Carte(c);

        carte.getClientsList().add(client);

        carte.initCarte();
        carte.getGrid()[c.getX()][c.getY()] = c;
        carte.getGrid()[client.getX()][client.getY()] = client;
        carte.displayCarte();
    } 
}
