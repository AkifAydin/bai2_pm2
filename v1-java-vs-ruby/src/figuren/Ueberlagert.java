package figuren;

public class Ueberlagert extends Figur {

    private Figur unten;
    private Figur oben;

    public Ueberlagert(Figur oben, Figur unten) {
        super();
        this.oben = oben;
        this.unten = unten;
    }


    public String toString() {
        //return  "ue(o=>" + oben + "u=>"+ unten+ ")";
        return String.format("ue(o=>%s,u=>%s)", oben.toString(), unten.toString());
    }

    @Override
    public boolean in(Punkt p) {
        return oben.in(p) || unten.in(p);
    }
}
