
package com.lennydennis.dukayangu.model;

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
    private double salePrice;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("customerReviewAverage")
    @Expose
    private double customerReviewAverage;

    /**
     * No args constructor for use in serialization
     *
     */
    public Product() {
    }

    public Product(String name, double salePrice, String image, double customerReviewAverage) {
        this.name = name;
        this.salePrice = salePrice;
        this.image = image;
        this.customerReviewAverage = customerReviewAverage;
    }

    /**
     *
     * @param image
     * @param salePrice
     * @param customerReviewAverage
     * @param name
     * @param sku
     * @param type
     */


    public Product(Integer sku, String name, String type, double salePrice, double customerReviewAverage, String image) {
        super();
        this.sku = sku;
        this.name = name;
        this.type = type;
        this.salePrice = salePrice;
        this.customerReviewAverage = customerReviewAverage;
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

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getCustomerReviewAverage() {
        return customerReviewAverage;
    }

    public void setCustomerReviewAverage(double customerReviewAverage) {
        this.customerReviewAverage = customerReviewAverage;
    }

}
