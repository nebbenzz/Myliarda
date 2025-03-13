package htoh;

public abstract class abstract_htoh implements htot_w{
     protected String nom;
     protected String type;
     protected int pv;
     protected int force;
     protected int atkspe;
     protected int rune;

     public abstract_htoh(String nom, String type, int pv, int force, int atkspe, int rune) {
         this.nom = nom;
         this.type = type;
         this.pv = pv;
         this.force = force;
         this.atkspe = atkspe;
         this.rune = rune;
     }

    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public int getForce() {
        return force;
    }

    public int getRune() {
        return rune;
    }

    public int getAtkSpe() {
         return atkspe;
    }

    public void setRune(int rune) {
         this.rune = rune;
    }

     public void subirDegats(int degats){
         this.pv -= degats;
         if (this.pv < 0) {
             this.pv = 0;  //pv != négatifs
         }
     }

     public void afficherInfos(){
          System.out.println(nom + " | Type : " + type + " | PV : " + pv + " | Force : " + force +  " | Attaque spéciale : " + atkspe + " | Rune : " + rune);
     }

}
