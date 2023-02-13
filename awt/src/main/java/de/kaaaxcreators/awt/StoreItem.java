package de.kaaaxcreators.awt;

public class StoreItem implements Cloneable {
    private String name;
    private String description;
    private Number price;
    private Number quantity;

    StoreItem(String name, String description, Number price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = 1;
    }

    StoreItem(String name, String description, Number price, Number quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }

    String getDescription() {
        return description;
    }
    void setDescription(String description) {
        this.description = description;
    }

    Number getPrice() {
        return price;
    }
    void setPrice(Number price) {
        this.price = price;
    }

    Number getQuantity() {
        return quantity;
    }
    void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "StoreItem [name=" + name + ", description=" + description + ", price=" + price + ", quantity=" + quantity + "]";
    }
}
