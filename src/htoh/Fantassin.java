package htoh;

public class Fantassin extends abstract_htoh{
    private final int coutRune = 8;


    public Fantassin(String nom) {
        super(nom, "fantassin", 75,21, 25,  59);
    }

    public String getNom(){
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

    @Override
    public int attaquer() {
        if(rune > coutRune) {
            System.out.println("\uD83D\uDCA5" + nom + " attaque avec sa lance qui inflige " + force + " de dégâts. \uD83D\uDCA5");
            rune -= coutRune;
            System.out.println("Runes d'" + nom + " restantes : " + rune + ".");
        }
        return getForce();
    }

    public int attaqueSpe() {
        if(rune > coutRune){
            System.out.println("\uD83D\uDCA5" + "La lance de " + nom + " s'agrandit et transperçe l'ennemi avec " + atkspe + " de dégâts !!\uD83D\uDCA5");
            rune -= coutRune;
            System.out.println("Runes de " + nom + " restantes : " + rune + ".");
        }
        return getAtkSpe();
    }
}
