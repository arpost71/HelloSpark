import java.util.ArrayList;
import java.util.Date;

/**
 * Created by alexpost1 on 4/8/15.
 */
public class Book {
    private String name;
    private double isbn;
    private String status;
    private String genre;
    private String publisher;
    private String readingLevel;
    private ArrayList<String> author = new ArrayList<String>();
    private String summary;
    private int quantity;
    private Date date;
    private String donor;

    Book(double i, String n, String a, String s, String stat, String g, String p, String r, int q, Date d, String don){
        name = n;
        isbn = i;
        status = stat;
        publisher = p;
        genre = g;
        readingLevel = r;
        author.add(a);
        summary = s;
        quantity = q;
        date = d;
        donor = don;
    }

    String getName(){
        return name;
    }

    double getIsbn(){
        return isbn;
    }

    String getStatus(){
        return status;
    }

    String getPublisher(){
        return publisher;
    }

    String getReadingLevel(){
        return readingLevel;
    }

    String getGenre(){
        return genre;
    }

    ArrayList<String> getAuthor(){
        return author;
    }

    String getSummary(){
        return summary;
    }

    int getQuantity(){
        return quantity;
    }

    Date getDate(){
        return date;
    }

    String getDonor(){
        return donor;
    }

    void updateQuantity(){
        quantity += 1;
    }
}
