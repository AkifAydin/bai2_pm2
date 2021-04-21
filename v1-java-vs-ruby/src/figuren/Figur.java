package figuren;

import original.Punkt;

public abstract class Figur {
    public abstract boolean in(Punkt p);

    public void printMe() {
        if (Math.random() < 0.5) {
            return;
        } else {
            System.out.println("TODO");
        }
    }
}
