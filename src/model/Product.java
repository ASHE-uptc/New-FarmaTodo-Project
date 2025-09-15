package model;

import java.time.LocalDate;

public class Product {
    private String pro_name;
    private int pro_id;
    private double pro_price;
    private LocalDate pro_expirarion;
    private int pro_stock;

    public Product(int pro_id, String pro_name, double pro_price, int pro_stock, LocalDate pro_expirarion){
        this.pro_id=pro_id;
        this.pro_name=pro_name;
        this.pro_price=pro_price;
        this.pro_expirarion=pro_expirarion;
        this.pro_stock=pro_stock;
    }

    public int getPro_id(){
        return pro_id;
    }

    public String getPro_name(){
        return pro_name;
    }

    public double getPro_price(){
        return pro_price;
    }

    public int getPro_stock(){
        return pro_stock;
    }

    public LocalDate getPro_expirarion() {
        return pro_expirarion;
    }


    public void setPro_expirarion(LocalDate pro_expirarion) {
        this.pro_expirarion = pro_expirarion;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public void setPro_price(double pro_price) {
        this.pro_price = pro_price;
    }

    public void setPro_stock(){
        this.pro_stock=pro_stock;
    }

    @Override
    public String toString() {
        return "Product [pro_name=" + pro_name + ", pro_id=" + pro_id + ", pro_price=" + pro_price + "Stock= "+pro_stock+", pro_expirarion="+ pro_expirarion + "]";
    }

    public void pro_showInfo(){
        System.out.println("Product Information--------- "+"\nProduct name: "+pro_name+"\nID: "+pro_id+"\nPrice: "+pro_price+"\n Stock: "+pro_stock+"\nExpiration: "+pro_expirarion);
    }
}