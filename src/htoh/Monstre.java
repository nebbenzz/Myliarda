package htoh;

import java.util.Random;

public class Monstre extends abstract_htoh{
    private static final String[] NOM_MONSTRES = {"Gorgoth", "Zarkus", "Mormag", "Lupia"};
    private static final String[] TYPES_MONSTRES = {"Orc", "Démon", "Golem", "Damné"};
    private static final Random rand = new Random();
    private boolean empoisonne = false;
    private int toursEmpoisonne = 0;

    public Monstre() {
        super(NOM_MONSTRES[rand.nextInt(NOM_MONSTRES.length)],
                TYPES_MONSTRES[rand.nextInt(TYPES_MONSTRES.length)],
                rand.nextInt(41) + 60,
                rand.nextInt(6) + 10,
                    rand.nextInt(8) + 12,
                    rand.nextInt(1));
    }

    public boolean isEmpoisonne(){
        return empoisonne;
    }

    public void setEmpoisonne(boolean empoisonne){
        this.empoisonne = empoisonne;
    }

    public int getToursEmpoisonne(){
        return toursEmpoisonne;
    }

    public void setToursEmpoisonne(int toursEmpoisonne){
        this.toursEmpoisonne = toursEmpoisonne;
    }

    public int attaquer(){
        switch (this.type){
            case "Orc":
                System.out.println("\uD83D\uDCA5" + nom + " lance sa hâche et inflige " + force + " de dégâts. \uD83D\uDCA5");
                return getForce();
            case "Démon":
                System.out.println("\uD83D\uDCA5" + nom + " déchaîne sa colère avec sa lance et inflige " + force + " de dégâts. \uD83D\uDCA5");
                return getForce();
            case "Golem":
                System.out.println("\uD83D\uDCA5" + nom + " lance un rocher et inflige " + force + " de dégâts. \uD83D\uDCA5");
                return getForce();
            case "Damné":
                System.out.println("\uD83D\uDCA5" + nom + " inflige une morsure de" + force + " de dégâts. \uD83D\uDCA5");
                return getForce();
            default:
                System.out.println("\uD83D\uDCA5" + nom + " attaque et inflige " + force + " de dégâts. \uD83D\uDCA5");
                return getForce();
        }
    }

    public int attaqueSpe() {
        switch (this.type){
            case "Orc":
                System.out.println("\uD83D\uDCA5" + nom + " tourne avec sa hâche et inflige " + atkspe + " de dégâts !!\uD83D\uDCA5");
                return getAtkSpe();
            case "Démon":
                System.out.println("\uD83D\uDCA5" + nom + " devient incontrôlable et détruit tout sur son passage en affligeant " + atkspe + " de dégâts !!\uD83D\uDCA5");
                return getAtkSpe();
            case "Golem":
                System.out.println("\uD83D\uDCA5" + nom + " provoque un tremblement de terre qui fait subir  " + atkspe + " de dégâts !!\uD83D\uDCA5");
                return getAtkSpe();
            case "Damné":
                System.out.println("\uD83D\uDCA5" + nom + " réussi à s'aggriper et déchire un membre infligeant  " + atkspe + " de dégâts !!\uD83D\uDCA5");
                return getAtkSpe();
            default:
                System.out.println("\uD83D\uDCA5" + nom + "déclenche son attaque spéciale et inflige " + atkspe + "de dégâts !!\uD83D\uDCA5");
                return getAtkSpe();
        }
    }
}
