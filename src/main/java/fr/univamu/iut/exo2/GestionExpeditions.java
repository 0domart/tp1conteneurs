package fr.univamu.iut.exo2;


import fr.univamu.iut.Conteneur;
import fr.univamu.iut.exo1.Lecteur;
import java.util.Collection;

public class GestionExpeditions {
    public static void main(String[] args) {

        Collection<Conteneur> conteneurs = Lecteur.charger("Conteneurs.ser");
    }
}
