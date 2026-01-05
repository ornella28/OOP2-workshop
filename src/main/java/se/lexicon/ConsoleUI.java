package se.lexicon;

import java.util.Scanner;

public class ConsoleUI {

    private final IVendingMachine vendingMachine;
    private final  Scanner scanner = new Scanner(System.in);

    // Constructor
    public ConsoleUI(IVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void start(){
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> insertCoin();
                    case "2" -> purchaseProduct();
                    case "3" -> returnChange();
                    case "4" -> vendingMachine.getProducts().forEach(product -> System.out.println(product.getDescription()));
                    case "5" -> {
                        System.out.println("Exiting...");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());

            }

        }



    }

    private void printMenu(){
        System.out.println("\n=======Vending Machine Menu:=========");
        System.out.println("1. Insert Coin");
        System.out.println("2. Purchase Product");
        System.out.println("3. Return Change");
        System.out.println("4. View Products");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void insertCoin(){
        System.out.println("Insert Coin (1: One Cent, 2: Two Cent, 3: Five Cent, 4: Ten Cent, 5: Twenty Cent, 6: Fifty Cent): ");
        String coinChoice = scanner.nextLine();
        Coin coin;
        switch (coinChoice) {
            case "1" -> coin = Coin.One_Cent;
            case "2" -> coin = Coin.Two_Cent;
            case "3" -> coin = Coin.Five_Cent;
            case "4" -> coin = Coin.Ten_Cent;
            case "5" -> coin = Coin.Twenty_Cent;
            case "6" -> coin = Coin.Fifty_Cent;
            default -> {
                System.out.println("Invalid coin choice.");
                return;
            }
        }
        vendingMachine.insertCoin(coin);
        System.out.println("Inserted " + coin.name() + ". Current balance: " + vendingMachine.getBalance() + " cents.");
    }



}
