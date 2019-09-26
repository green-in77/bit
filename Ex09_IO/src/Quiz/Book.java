package Quiz;

import java.io.Serializable;

public class Book implements Serializable {
	final String isbn;

    String title;

    int price;

    public Book(String isbn, String title,int price){

           this.isbn = isbn;

           this.title = title;

           this.price = price;

    }

    public String ISBN(){

           return isbn;

    }

    public String toString(){

           return String.format("ISBN:%s �̸�:%s ����:%d", isbn, title,price);
     }
}
