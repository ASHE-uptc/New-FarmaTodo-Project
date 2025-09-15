package model;

public class Client extends Person {

    private int pro_amount;

    public Client(String name, char doc_type, String doc_num, int pro_amount) {
        super(name, doc_type, doc_num);
    }

    public int getPro_amount() {
        return pro_amount;
    }

    public void setPro_amount(int pro_amount) {
        this.pro_amount = pro_amount;
    }
}
