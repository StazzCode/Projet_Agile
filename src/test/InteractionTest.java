package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Main;
import main.Character;
import main.Client;
import main.Carte;

public class InteractionTest {
    public Character perso;
    public Carte carte;
    public Client client;

    @BeforeEach
    public void initialization(){
        this.perso = new Character(2,2);
        this.carte = new Carte(perso);
        this.client = new Client(2,3);

        carte.initCarte();
        carte.getGrid()[perso.getY()][perso.getX()] = perso;
        carte.getGrid()[client.getY()][client.getX()] = client;
    }

    @Test
    public void isNearClientTest(){
        assertEquals(client,Main.isNearClient(perso,carte.getGrid()));
    }
}
