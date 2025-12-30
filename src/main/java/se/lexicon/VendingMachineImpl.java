package se.lexicon;

import java.util.List;

public class VendingMachineImpl implements IVendingMachine{

    private final List<Product>products;
    private int balance;


    // Constructor


    public VendingMachineImpl(List<Product> products) {
        this.products = products;
        this.balance = 0;
    }

    //method to find product by id
    private Product findProduct(int productId){
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null; // Product not found
    }

    //override methods to insert coin
    @Override
    public void insertCoin(Coin coin) {
        balance+=coin.getValue();
    }
    //override method to get balance
    @Override
    public int getBalance() {
        return balance;
    }

    //override method to buy product
    @Override
    public Product purchaseProduct(int productId) {
        Product product = findProduct(productId);
        if (product == null)
            throw new IllegalArgumentException("Product with ID " + productId + " not found");
        if (product.getQuantity()<=0)
            throw new IllegalStateException("Product is out of stock");
        if(balance < product.getPrice())
            throw new IllegalStateException("Insufficient balance");

      product.decreaseQuantityByOne();
        balance -= product.getPrice();

        return product;

    }

    //override method to return change


    @Override
    public int returnChange() {
        int change = balance;
        balance = 0;
        return change;
    }

    //override method to get products

    @Override
    public List<Product> getProducts() {
        return List.copyOf(products);
    }


}
