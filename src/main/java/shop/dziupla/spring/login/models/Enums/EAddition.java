package shop.dziupla.spring.login.models.Enums;

public enum EAddition {
    ADDITION_DECORATION(100f),
    ADDITION_INSURANCE(600f),
    ADDITION_DELIVERY(200f);

    private Float price;

    EAddition(Float price) {
        this.price = price;
    }
    public Float getPrice() {
        return price;
    }
}
