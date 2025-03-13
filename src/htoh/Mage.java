package htoh;

public class Mage extends abstract_htoh{
    private final int coutRune = 11;

    public Mage(String nom){
        super(nom, "mage", 80, 23, 29, 51);
    }

    public String getNom(){
        return nom;
    }

    public int getRune(){
        return rune;
    }

    public int getAtkSpe(){
        return atkspe;
    }

    public void setRune(int rune){
        this.rune = rune;
    }

    public int attaquer() {
        if(rune > coutRune){
            System.out.println("\uD83D\uDCA5" + nom + " lance un sort et inflige " + force + " de dégâts. \uD83D\uDCA5");
            rune -= coutRune;
            System.out.println("Runes de " + nom + " restantes : " + rune + ".");
        }
        return getForce();
    }

    public int attaqueSpe() {
        if(rune > coutRune){
            System.out.println("\uD83D\uDCA5" + nom + " puise dans son for intérieur et génère une boule de feu qui inflige " + atkspe + " de dégâts !!\uD83D\uDCA5");
            rune -= coutRune;
            System.out.println("Runes de " + nom + " restantes : " + rune + ".");
        }
        return getAtkSpe();
    }
}
