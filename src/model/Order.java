package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int ord_id;
    private List<Product> products=new ArrayList<>();
    private LocalDate ord_date;

    public Order(int ord_id,LocalDate ord_date){
        this.ord_id=ord_id;
        this.ord_date=ord_date;
    }

    public LocalDate getOrd_date() {
        return ord_date;
    }

    public void setOrd_date(LocalDate ord_date) {
        this.ord_date = ord_date;
    }

    public int getOrd_id() {
        return ord_id;
    }

    public void setOrd_id(int ord_id){
        this.ord_id = ord_id;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    public void AddProduct(Product newProduct){
        products.add(newProduct);
    }

    public double TotalCost(){
        double totalCost=0; //value 0,00 by default

        for(int i=0;i<products.size();i++){
            totalCost+= products.get(i).getPro_price();
        }
        return totalCost;
    }

    public void ShowOrder(){
        System.out.println("\nFarmaTodo Order /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println("Order ID: "+ord_id+"--------------------------------------------");
        System.out.println("Order Date: "+LocalDate.now()+"\n");

        int counter=1;

        for(Product p: products){
            System.out.println("Product N."+counter+": ");
            System.out.println("Product ID: "+p.getPro_id());
            System.out.println("Name: "+p.getPro_name());
            System.out.println("Price: "+p.getPro_price());
            System.out.println("\n");
        }
    }

    public String getOrderDetails(){
    StringBuilder sb = new StringBuilder();
    int counter = 1;
    sb.append("\n----------------------------------------------------------------------------------------\n");
     for(Product p : products){
        sb.append("Product N.").append(counter++).append(": ")
          .append(p.getPro_name())
          .append(" - $")
          .append(String.format("%,.2f", p.getPro_price()))
          .append("\n");
    }

    sb.append("----------------------------------------------------------------------------------------");
    sb.append("\nTOTAL: $").append(String.format("%,.2f", TotalCost()));
    sb.append("\n");

    return sb.toString();
}
}