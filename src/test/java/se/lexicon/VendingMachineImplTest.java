package se.lexicon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;



import java.util.ArrayList;
import java.util.List;

public class VendingMachineImplTest {

    private VendingMachineImpl vendingMachine;
    private Snack chips;

    @BeforeEach
    void setUp() {

        chips = new Snack(1, "Chips", 25, 10, false);
        List<Product> products = new ArrayList<>();
        products.add(chips);
        products.add(new Beverage(2, "Cookies", 20, 5, false));
        products.add(new Fruit(3, "Banana", 15, 8, false));
        vendingMachine = new VendingMachineImpl(products);




    }
    @Test
    void testInsertCoinAndGetBalance() {

        //TEST : case 1: Insert coins
        vendingMachine.insertCoin(Coin.Twenty_Cent);
        vendingMachine.insertCoin(Coin.Five_Cent);

        int balance = vendingMachine.getBalance();
        assert balance == 25 : "Balance should be 25 cents after inserting coins.";
    }

    @Test
    void testRejectInvalidCoin() {
        int initialBalance = vendingMachine.getBalance();
        try {
            vendingMachine.insertCoin(null); // Attempt to insert an invalid coin
            assert false; // Should not reach here
        } catch (IllegalArgumentException e) {
            // expected exception: do nothing
        }

        int balanceAfterInvalidCoin = vendingMachine.getBalance();
        assert balanceAfterInvalidCoin == initialBalance : "Balance should remain unchanged after inserting an invalid coin.";


    }

    @Test
    void testPurchaseProduct_Success() {

        vendingMachine.insertCoin(Coin.Twenty_Cent);
        vendingMachine.insertCoin(Coin.Five_Cent);

        Product purchasedProduct = vendingMachine.purchaseProduct(1); // Purchase Chips
        assert purchasedProduct != null : "Purchased product should not be null.";
        assert purchasedProduct.getId() == 1 : "Purchased product ID should be 1.";
        assert vendingMachine.getBalance() == 0 : "Balance should be 0 cents after purchase.";
        assert chips.getQuantity() == 9 : "Chips quantity should decrease by one.";
    }

    @Test
    void testPurchaseProduct_OutOfStock() {
      //Create a product that is out of stock
        Snack outOfStockSnack = new Snack(4, "OutOfStockSnack", 30, 0, false);
        List<Product> products = new ArrayList<>();
        products.add(outOfStockSnack);
        VendingMachineImpl vmWithOutOfStock = new VendingMachineImpl(products);

        //Insert sufficient coins
        vendingMachine.insertCoin(Coin.Twenty_Cent);

        int initialBalance = vendingMachine.getBalance();
        int initialQuantity = outOfStockSnack.getQuantity();

        //When
        try {
            vmWithOutOfStock.purchaseProduct(4); // Attempt to purchase out of stock product
            assert false : "Expected IllegalStateException for out of stock product.";
        } catch (IllegalStateException e) {
            //excepted exception
        }

        //Then
        assert vendingMachine.getBalance() == initialBalance : "Balance should remain unchanged after attempting to purchase out of stock product.";
        assert outOfStockSnack.getQuantity() == initialQuantity : "Product quantity should remain unchanged after attempting to purchase out of stock product.";

    }

    @Test
    void testPurchaseProduct_InsufficientBalance() {
        vendingMachine.insertCoin(Coin.Ten_Cent);

        try {
            vendingMachine.purchaseProduct(2); // Attempt to purchase Cookies (price 20)
            assert false : "Expected IllegalStateException for insufficient balance.";
        } catch (IllegalStateException e) {
            assert e.getMessage().equals("Insufficient balance") : "Exception message should indicate insufficient balance.";
        }
    }

    @Test
    void testReturnChange() {

        vendingMachine.insertCoin(Coin.Twenty_Cent);
        vendingMachine.insertCoin(Coin.Five_Cent);

        int change = vendingMachine.returnChange();
        assert change == 25 : "Returned change should be 25 cents.";
        assert vendingMachine.getBalance() == 0 : "Balance should be 0 cents after returning change.";
    }




}
