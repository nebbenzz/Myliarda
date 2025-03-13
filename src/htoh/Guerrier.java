package htoh;

public class Guerrier extends abstract_htoh{
    private final int coutRune = 7;

    public Guerrier(String nom) {
        super(nom, "guerrier", 100, 15, 19, 73);
    }

    public String getNom() {
        return nom;
    }

    public int getRune(){
        return rune;
    }

    public void setRune(int rune){
        this.rune = rune;
    }

    public int getAtkSpe(){
        return atkspe;
    }

    public int attaquer(){
        if(rune > coutRune){
            System.out.println("\uD83D\uDCA5" + nom + " attaque avec son épée qui inflige " + force + " de dégâts.");
            rune -= coutRune;
            System.out.println("Runes de " + nom + " restantes : " + rune + ".");
        }
        return getForce();
    }

    public int attaqueSpe() {
        if(rune > coutRune){
            System.out.println("\uD83D\uDCA5" + "L'épée de " + nom + " est frappée par la foudre et elle inflige " + atkspe + " de dégâts !!\uD83D\uDCA5");
            rune -= coutRune;
            System.out.println("Runes de " + nom + " restantes : " + rune + ".");
        }
        return getAtkSpe();
    }

}
