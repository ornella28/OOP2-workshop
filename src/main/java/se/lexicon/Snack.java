package se.lexicon;

public class Snack extends Product{

    private final boolean containsNuts;

    // Constructor

    public Snack(int id, String name, int price, int quantity, boolean containsNuts) {
        super(id, name, price, quantity);
        this.containsNuts = containsNuts;
    }

    // Getter
    public boolean isContainsNuts() {
        return containsNuts;
    }

    // Override getDescription method


    @Override
    public String getDescription() {
        return super.getDescription() + ", Contains Nuts: " + containsNuts;
    }
}
