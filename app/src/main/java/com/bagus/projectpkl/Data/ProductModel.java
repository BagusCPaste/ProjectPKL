package com.bagus.projectpkl.Data;

public class ProductModel {
    public String name, store, img;
    public long price, price_old;
    public int discount;
    public float rating;

    //public ProductModel(String name, String store, long price, long price_old, String img, float rating, int discount) {
    public ProductModel(String name, String img) {
        this.name = name;
        this.img = img;
    }
}
