package se.lexicon;

public enum Coin {

    One_Cent(1),
    Two_Cent(2),
    Five_Cent(5),
    Ten_Cent(10),
    Twenty_Cent(20),
    Fifty_Cent(50),
    ;


    private final int value;

    // Constructor


    Coin(int value) {
        this.value = value;
    }

    //getter
    public int getValue() {
        return value;
    }
}
