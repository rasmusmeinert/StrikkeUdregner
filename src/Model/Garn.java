package Model;

public class Garn {
    private double løbelængde; // løbelængde per x gram;
    private double gram;


    public Garn(double løbelængde, double gram) {
        this.løbelængde = løbelængde;
        this.gram = gram;
    }

    public double getLøbelængde() {
        return løbelængde;
    }

    public double getGram() {
        return gram;
    }
}
