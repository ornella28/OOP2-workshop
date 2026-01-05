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
        System.out.println();

        //Create products list
        List<Product>products = new ArrayList<>();
        products.add(new Snack(1, "Chocolate Bar", 15, 50, false));
        products.add(new Beverage(2, "Cola", 10, 100, true));
        products.add(new Fruit(3, "Apple", 5, 200, true));

        //Create vending machine
        IVendingMachine vendingMachine = new VendingMachineImpl(products);

        //show starting balance and products
        System.out.println("Starting balance: " + vendingMachine.getBalance() + " cents");
        System.out.println("Available products:");
        for (Product product : vendingMachine.getProducts()) {
            System.out.println(product.getDescription());
        }
        System.out.println();


        //Insert coins
        vendingMachine.insertCoin(Coin.Twenty_Cent);
        vendingMachine.insertCoin(Coin.Fifty_Cent);
        System.out.println("Balance after inserting coins: " + vendingMachine.getBalance() + " cents");

        //Purchase product(id=2 -> Cola, price=10)
        Product purchasedProduct = vendingMachine.purchaseProduct(2);
        System.out.println("Purchased product: " + purchasedProduct.getDescription());
        System.out.println("Balance after purchase: " + vendingMachine.getBalance() + " cents");

        //Return change
        int change = vendingMachine.returnChange();
        System.out.println("Returned change: " + change + " cents");
        System.out.println("Final balance: " + vendingMachine.getBalance() + " cents");
        System.out.println();

        //show remaining products
        System.out.println("Remaining products:");
        for (Product product : vendingMachine.getProducts()) {
            System.out.println(product.getDescription());
        }
        System.out.println();

        //Insert coins for further purchases
        vendingMachine.insertCoin(Coin.Ten_Cent);
        vendingMachine.insertCoin(Coin.Twenty_Cent);
        System.out.println();

        //Purchase more products to test stock decrease (id=1 -> Chocolate Bar, price=15)
        Product purchasedProduct2 = vendingMachine.purchaseProduct(1);
        System.out.println("Purchased product: " + purchasedProduct2.getDescription());
        System.out.println("Balance after purchase: " + vendingMachine.getBalance() + " cents");
        System.out.println();

        //return change
        int change2 = vendingMachine.returnChange();
        System.out.println("Returned change: " + change2 + " cents");
        System.out.println("Final balance: " + vendingMachine.getBalance() + " cents");

        //show remaining products
        System.out.println("Remaining products:");
        for (Product product : vendingMachine.getProducts()) {
            System.out.println(product.getDescription());
        }
        System.out.println();

        ConsoleUI consoleUI = new ConsoleUI(vendingMachine);
        consoleUI.start();














    }
}
