package se.lexicon;

public abstract class Product {

    private final int id;
    private final String name;
    private final int price;
    private int quantity;


    // Constructor


    public Product(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    // Getters


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    //methods

    public void decreaseQuantityByOne(){
        if(quantity<=0){
            throw new IllegalStateException("Product is out of stock");
        }
        quantity--;
    }

    public String getDescription(){
        return "ID: " + id + ", Name: " + name + ", Price: " + price + ", Quantity: " + quantity;
    }
}
