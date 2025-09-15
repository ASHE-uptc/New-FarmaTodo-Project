package model;
import java.util.Scanner;

public class Person {
    private String name;
    private char doc_type;
    private String doc_num;


    public Person(String name, char doc_type, String doc_num){
        this.name=name;
        this.doc_type=doc_type;
        this.doc_num=doc_num;
    }

    public String getName(){
        return name;
    }

    public char getDoc_type(){
        return doc_type;
    }

    public String getDoc_num(){
        return doc_num;
    }

    public static Person register(){
        Scanner ent=new Scanner(System.in);

        System.out.println("What's your name?");
        String name=ent.nextLine();

        System.out.println("What's your document type?");
        char doc_type=ent.nextLine().charAt(0);

        System.out.println("What's your document number?");
        String doc_num=ent.nextLine();

        return new Person(name, doc_type, doc_num); 
    
    }
    public void cli_showInfo(){
        System.out.println("\nClient Information 0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0 "+"\n    Client name: "+name+"\n    ID Type: "+doc_type+"\n    sNumber: "+doc_num+"\n0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0 ");
    }
    
}