package fr.univamu.iut.exo1;

import fr.univamu.iut.Conteneur;
import fr.univamu.iut.exo2.CompareDistances;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Lecteur {
    public static Collection<Conteneur> charger(String fichier) {

        ArrayList<Conteneur> conteneurs = new ArrayList<>();
        //Ouvrir le fichier dont le nom est donné en argument.
        FileInputStream fis = null;
        ObjectInputStream abc = null;
        try {
            fis = new FileInputStream(fichier);
            abc = new ObjectInputStream(fis);
            // Lire les objets à partir du flux qu'on vient d'ouvrir, dans une boucle infini

            while (true) {

                Object objet = null;
                objet = abc.readObject();
                if (objet.getClass().equals(Conteneur.class)) {
                    System.out.println(objet);
                    conteneurs.add((Conteneur) objet);
                }
            }
        }

          //Fin du fichier
          catch (EOFException e) {
              try {
                  abc.close();
              } catch (IOException ex) {
                  ex.printStackTrace();
              }

          }
          // Fichier existe pas
          catch (FileNotFoundException e) {
            System.out.println("Erreur1");
            e.printStackTrace();


        } catch (IOException e) {
            System.out.println("Erreur2");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            System.out.println("Erreur3");
            e.printStackTrace();
        }
        Collections.sort(conteneurs, new CompareDistances());
        return conteneurs;
    }
}
