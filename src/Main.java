import htoh.*;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        boolean valStart = rand.nextBoolean();

        System.out.println("----- COMBAT EN COURS -----\n");

        //génération du monstre
        Monstre monstre = new Monstre();
        System.out.println("Un monstre apparait !");
        monstre.afficherInfos();
        waitseconde();

        //sélection héros
        abstract_htoh heros = selectionnerHeros(scanner);
        if (heros == null) {
            System.out.println("Vous n'avez pas choisi de classe, combat annulé");
            return;
        }

        //lancer le combat
        combat(scanner, heros, monstre, valStart);
    }

    //méthode de récupération de runes après attaque du héros
    public static void recupRunes(abstract_htoh heros){
        int min = 3;
        int max = 8;
        int recupRunes = ThreadLocalRandom.current().nextInt(min, max);
        if (heros instanceof Guerrier) {
            ((Guerrier) heros).setRune(heros.getRune() + recupRunes);
            System.out.println(heros.getNom() + " a récupéré " + recupRunes + " runes !");
        } else if (heros instanceof Fantassin) {
            ((Fantassin) heros).setRune(heros.getRune() + recupRunes);
            System.out.println(heros.getNom() + " a récupéré " + recupRunes + " runes !");
        } else if (heros instanceof Mage) {
            ((Mage) heros).setRune(heros.getRune() + recupRunes);
            System.out.println(heros.getNom() + " a récupéré " + recupRunes + " runes !");
        } else if (heros instanceof Sorcier) {
            ((Sorcier) heros).setRune(heros.getRune() + recupRunes);
            System.out.println(heros.getNom() + " a récupéré " + recupRunes + " runes !");
        }
    }

    //méthode de sélection d'un héros
    private static abstract_htoh selectionnerHeros(Scanner scanner) {
        System.out.println("\n Sélectionner un combattant");
        while (true) {
            System.out.print("> Quel combattant souhaitez-vous prendre ?");
            String choix = scanner.nextLine().toLowerCase();

            switch (choix) {
                case "guerrier":
                    return new Guerrier("Conan");
                case "fantassin":
                    return new Fantassin("Ilgrad");
                    case "mage":
                        return new Mage("Dolpher");
                        case "sorcier":
                            return new Sorcier("Daskin");
                        default:
                            System.out.print("Classe inconnue, combat annulé");
                            break;
            }
        }
    }

    //logique de combat
    private static void combat(Scanner scanner, abstract_htoh heros, Monstre monstre, boolean valStart) {
        boolean combatEnCours = true;

        while (combatEnCours) {
            if (valStart) {
                combatJoueur(scanner, heros, monstre);
            } else {
                combatMonstre(heros, monstre);
            }

            if(monstre.isEmpoisonne()){
                Sorcier.appliquerPoison(monstre);
            }
            afficherPv(heros, monstre);

            if (heros.getPv() <= 0) {
                System.out.println("\uD83D\uDC80 Vous avez perdu !");
                combatEnCours = false;
            } else if (monstre.getPv() <= 0) {
                System.out.println("\uD83C\uDF89 Vous avez gagné !");
                combatEnCours = false;
            }

            valStart = !valStart;
            waitseconde();
        }
    }

    //méthode de combat du héros
    private static void combatJoueur(Scanner scanner, abstract_htoh heros, Monstre monstre) {
        System.out.println("\n> C'est à vous de jouer !" +
                "Que souhaitez-vous faire ? (attaquer (a) ou ne rien faire(o) )");
        String dec = scanner.nextLine().toLowerCase();
        switch (dec) {
            case "a":
                int proba = probAtkSpe();
                if(proba < 25) {
                    if (heros instanceof Sorcier sorcier) {
                        sorcier.definirCible(monstre); // Définir la cible
                        int degats = sorcier.attaqueSpe();
                        monstre.subirDegats(degats);
                        waitseconde();
                    } else {
                        int degats = heros.attaqueSpe();
                        monstre.subirDegats(degats);
                        waitseconde();
                    }
                }else {
                    int degats = heros.attaquer();
                    monstre.subirDegats(degats);
                    waitseconde();
                }
                recupRunes(heros);
                break;
                case "o":
                    int runesRecuperees = recupRunesWPass(heros);
                    System.out.println("Vous avez choisi de ne rien faire. " + heros.getNom() + " se repose et récupère " + runesRecuperees +  " runes." +
                            " Total de runes : " + heros.getRune() + ".");
        }
    }

    //méthode de combat du monstre
    private static void combatMonstre(abstract_htoh heros, Monstre monstre) {
        System.out.println("\n> C'est au monstre d'engager le combat !");
        int proba = probAtkSpe();
        if(proba < 7) {
            int degats = monstre.attaqueSpe();
            heros.subirDegats(degats);
            waitseconde();
        }else {
            int degats = monstre.attaquer();
            heros.subirDegats(degats);
            waitseconde();
        }
    }

    private static int probAtkSpe(){
        Random rand = new Random();
        int proba = rand.nextInt(100);
        return proba;
    }

    //méthode affichage pv héros/monstre
    private static void afficherPv(abstract_htoh heros, Monstre monstre) {
        System.out.println("\n---------------");
        System.out.println("Vos PV : " + heros.getPv());
        waitseconde();
        System.out.println("PV du monstre: " + monstre.getPv());
        System.out.println("---------------");
    }

    //méthode de regain de runes si o pressé
    public static int recupRunesWPass(abstract_htoh heros) {
        int min = 6;
        int max = 13;
        int recupRunes = ThreadLocalRandom.current().nextInt(min, max);

        heros.setRune(heros.getRune() + recupRunes);

        return recupRunes;
    }

    //lisibilite - temps = 1sec
    public static void waitseconde(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}