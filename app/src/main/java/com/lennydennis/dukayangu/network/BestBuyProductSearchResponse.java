
package com.lennydennis.dukayangu.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lennydennis.dukayangu.model.Product;

import java.util.List;

public class BestBuyProductSearchResponse {

    @SerializedName("from")
    @Expose
    private Integer from;
    @SerializedName("to")
    @Expose
    private Integer to;
    @SerializedName("currentPage")
    @Expose
    private Integer currentPage;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("totalPages")
    @Expose
    private Integer totalPages;
    @SerializedName("queryTime")
    @Expose
    private String queryTime;
    @SerializedName("totalTime")
    @Expose
    private String totalTime;
    @SerializedName("partial")
    @Expose
    private Boolean partial;
    @SerializedName("canonicalUrl")
    @Expose
    private String canonicalUrl;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public BestBuyProductSearchResponse() {
    }

    /**
     *
     * @param total
     * @param canonicalUrl
     * @param totalTime
     * @param totalPages
     * @param queryTime
     * @param from
     * @param to
     * @param currentPage
     * @param partial
     * @param products
     */
    public BestBuyProductSearchResponse(Integer from, Integer to, Integer currentPage, Integer total, Integer totalPages, String queryTime, String totalTime, Boolean partial, String canonicalUrl, List<Product> products) {
        super();
        this.from = from;
        this.to = to;
        this.currentPage = currentPage;
        this.total = total;
        this.totalPages = totalPages;
        this.queryTime = queryTime;
        this.totalTime = totalTime;
        this.partial = partial;
        this.canonicalUrl = canonicalUrl;
        this.products = products;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public String getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(String queryTime) {
        this.queryTime = queryTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public Boolean getPartial() {
        return partial;
    }

    public void setPartial(Boolean partial) {
        this.partial = partial;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}