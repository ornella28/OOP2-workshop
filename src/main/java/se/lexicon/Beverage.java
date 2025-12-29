package se.lexicon;

public class Beverage extends Product{

    private final boolean isCarbonated;

    // Constructor
    public Beverage(int id, String name, int price, int quantity, boolean isCarbonated) {
        super(id, name, price, quantity);
        this.isCarbonated = isCarbonated;
    }
    // Getter

    public boolean isCarbonated() {
        return isCarbonated;
    }

    // Override getDescription method:polymorphism

    @Override
    public String getDescription() {
        return super.getDescription() + ", Is Carbonated: " + isCarbonated;
    }
}
