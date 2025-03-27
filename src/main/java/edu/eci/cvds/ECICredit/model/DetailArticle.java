package edu.eci.cvds.ECICredit.model;

public class DetailArticle {
    private Product product;

    public DetailArticle(Product product, Integer quantity, Integer price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    private Integer quantity;
    private Integer price;



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
