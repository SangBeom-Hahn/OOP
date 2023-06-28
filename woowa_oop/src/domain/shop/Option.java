package domain.shop;

public class Option {
    private String name;
    private Money price;

    public Option(String name, Money price) {
        this.name = name;
        this.price = price;
    }
}