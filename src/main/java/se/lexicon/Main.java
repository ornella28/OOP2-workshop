package se.lexicon;

public class Main {


    static void main() {

        Product snack = new Snack(1, "Chocolate Bar", 15, 50, true);
        Product beverage = new Beverage(2, "Cola", 10, 100, true);
        Product fruit = new Fruit(3, "Apple", 5, 200, false);

        System.out.println(snack.getDescription());
        System.out.println(beverage.getDescription());
        System.out.println(fruit.getDescription());

    }
}
