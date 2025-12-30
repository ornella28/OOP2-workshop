package se.lexicon;

import java.util.ArrayList;
import java.util.List;

public class Main {


    static void main() {

        //Create products

        Product snack = new Snack(1, "Chocolate Bar", 15, 50, true);
        Product beverage = new Beverage(2, "Cola", 10, 100, true);
        Product fruit = new Fruit(3, "Apple", 5, 200, false);

        System.out.println(snack.getDescription());
        System.out.println(beverage.getDescription());
        System.out.println(fruit.getDescription());

        //Create products list
        List<Product>products = new ArrayList<>();
        products.add(new Snack(1, "Chocolate Bar", 15, 50, false));
        products.add(new Beverage(2, "Cola", 10, 100, true));
        products.add(new Fruit(3, "Apple", 5, 200, true));

        //Create vending machine
        IVendingMachine vendingMachine = new VendingMachineImpl(products);









    }
}
