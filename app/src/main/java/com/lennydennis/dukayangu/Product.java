
package com.lennydennis.dukayangu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("sku")
    @Expose
    private Integer sku;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("salePrice")
    @Expose
    private Double salePrice;
    @SerializedName("image")
    @Expose
    private String image;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Product() {
    }

    /**
     * 
     * @param image
     * @param salePrice
     * @param name
     * @param sku
     * @param type
     */
    public Product(Integer sku, String name, String type, Double salePrice, String image) {
        super();
        this.sku = sku;
        this.name = name;
        this.type = type;
        this.salePrice = salePrice;
        this.image = image;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
