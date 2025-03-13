package htoh;

public class Sorcier extends abstract_htoh{
    private final int coutRune = 14;
    private Monstre cibleEmpoisonnee;

    public Sorcier(String nom){
        super(nom, "sorcier", 84, 26, 18, 52);
    }

    public int attaquer(){
        if(rune > coutRune){
            System.out.println("\uD83D\uDD25" + nom + " lance une boule de feu et inflige " + force + " de dégâts. \uD83D\uDD25");
            rune -= coutRune;
            System.out.println("Runes de " + nom + " restantes : " + rune + ".");
        }
        return getForce();
    }

    public int attaqueSpe() {
        if(rune > coutRune){
            System.out.println("\uD83D\uDCA5" + nom + " utilise la magie noire pour empoisonner son ennemi durant 3 tour, le poison afflige " + atkspe + " de dégâts !!\uD83D\uDCA5");
            rune -= coutRune;
            cibleEmpoisonnee.setEmpoisonne(true); //active le poison
            cibleEmpoisonnee.setToursEmpoisonne(3); //durée poison
            System.out.println("Runes de " + nom + " restantes : " + rune + ".");
        }
        return getAtkSpe();
    }

    public void definirCible(Monstre cibleEmpoisonnee){
        this.cibleEmpoisonnee = cibleEmpoisonnee;
    }

    public static void appliquerPoison(Monstre monstre) {
            int degatsPoison = 4;
            monstre.subirDegats(degatsPoison);
            System.out.println("\uD83E\uDDEA" + monstre.getNom() + " souffre du poison et perd " + degatsPoison + " PV ! \uD83E\uDDEA");

            monstre.setToursEmpoisonne(monstre.getToursEmpoisonne() - 1);

            if (monstre.getToursEmpoisonne() <= 0) {
                monstre.setEmpoisonne(false);
                System.out.println(monstre.getNom() + " n'est plus empoisonné !");
            }
    }

}
