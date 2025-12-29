package se.lexicon;

public class Fruit extends Product{

    private final boolean isRipe;

    // Constructor
    public Fruit(int id, String name, int price, int quantity, boolean isRipe) {
        super(id, name, price, quantity);
        this.isRipe = isRipe;
    }
    // Getter
    public boolean isRipe() {
        return isRipe;
    }
    // Override getDescription method:polymorphism


    @Override
    public String getDescription() {
        return super.getDescription() + ", Is Ripe: " + isRipe;
    }
}
