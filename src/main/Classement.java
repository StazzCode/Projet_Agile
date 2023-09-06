package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Classement {
    private static final String FICHIER_CLASSEMENT = "../../res/classement.txt";

    public static void enregistrerScore(String nomJoueur, int score) {
        try (FileWriter fichier = new FileWriter("scores.txt", true); // Le deuxième argument "true" indique d'ajouter au fichier existant
             PrintWriter writer = new PrintWriter(fichier)) {
            writer.println(nomJoueur + "/" + score);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> lireScores(String nomFichier) {
        Map<String, Integer> scoresMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] elements = ligne.split("/");
                if (elements.length == 2) {
                    String nom = elements[0].trim();
                    int score = Integer.parseInt(elements[1].trim());
                    scoresMap.put(nom, score);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Triez la HashMap par score (ordre croissant)
        List<Map.Entry<String, Integer>> listeTriee = new ArrayList<>(scoresMap.entrySet());
        Collections.sort(listeTriee, (e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()));

        // Créez une nouvelle HashMap triée
        Map<String, Integer> scoresMapTrie = new HashMap<>();
        for (Map.Entry<String, Integer> entry : listeTriee) {
            scoresMapTrie.put(entry.getKey(), entry.getValue());
        }

        return scoresMapTrie;
    }

    public void classementToString() {
        String nomFichier = "scores.txt";
        Map<String, Integer> scores = lireScores(nomFichier);

        // Afficher le classement trié par score (ordre croissant)
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
