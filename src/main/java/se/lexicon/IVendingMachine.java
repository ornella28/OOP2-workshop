package se.lexicon;

import java.util.List;

public interface IVendingMachine {

    //list of functionalities

    void insertCoin(Coin coin);
    int getBalance();
    Product purchaseProduct(int productId);
    int returnChange();
    List<Product> getProducts();





}
