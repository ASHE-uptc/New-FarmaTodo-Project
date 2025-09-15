package model;

public class Druggist extends Person{
    
    private String druggist_user;
    private String druggist_password;

    public Druggist(String name, char doc_type, String doc_num, String druggist_user, String druggist_password) {
        super(name, doc_type, doc_num);
        this.druggist_user = druggist_user;
        this.druggist_password = druggist_password;
    }
    
    public String getDruggist_user() {
        return druggist_user;
    }
    public void setDruggist_user(String druggist_user) {
        this.druggist_user = druggist_user;
    }
    public String getDruggist_password() {
        return druggist_password;
    }
    public void setDruggist_password(String druggist_password) {
        this.druggist_password = druggist_password;
    }

    @Override
    public String toString() {
        return "Name :"+getName()+" \n "+ "Doc type: "+getDoc_type()+" \n "+"Doc Num: "+
        getDoc_num()+" \n "+"User: "+getDruggist_user()+ " \n "+"Password: "+getDruggist_password()+"\n";
    }


    
}
