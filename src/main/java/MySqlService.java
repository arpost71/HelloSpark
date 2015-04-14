import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by alexpost1 on 4/7/15.
 */
public class MySqlService {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String url= "jdbc:mysql://localhost:3306/test";

    MySqlService(String un, String pw) {
        String username = un;
        String password = pw;
        con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    public void close(){
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }


        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(ReadingNET.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);
        }
    }
    public boolean isConnected(){
        if(con != null)
            return true;
        else
            return false;
    }

    public String selectBook(String item, String isbn){
        String value = null;
        try{
            pst = con.prepareStatement("SELECT " + item + " FROM books WHERE isbn = " + isbn);
            System.out.println(pst);
            rs = pst.executeQuery();
            while (rs.next()){
                value = rs.getString(1);
            }
        }catch(SQLException e){
            Logger lgr = Logger.getLogger(ReadingNET.class.getName());
            lgr.log(Level.WARNING, e.getMessage(), e);
        }
        return value;
    }

    public ArrayList<ArrayList<String>> selectBooks(String item, String table){
        ArrayList<ArrayList<String>> items = new ArrayList<ArrayList<String>>();
        try {
            pst = con.prepareStatement("SELECT " + item + " FROM books");
            rs = pst.executeQuery();
            while (rs.next()) {
                ArrayList<String> books = new ArrayList<String>();
                for (int j = 1; j < 8; j++) {
                    books.add(rs.getString(j));
                }
                items.add(books);
            }

        }catch (SQLException ex){
                Logger lgr = Logger.getLogger(ReadingNET.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
        }
        System.out.println(items.size());
        return items;
    }

    public ArrayList<ArrayList<String>> searchClients(String item, String type, String table){
        ArrayList<ArrayList<String>> items = new ArrayList<ArrayList<String>>();
        try {
            pst = con.prepareStatement("SELECT * FROM " + table + " WHERE " + type +" LIKE '%"+ item + "%'");
            rs = pst.executeQuery();
            while (rs.next()) {
                ArrayList<String> clients = new ArrayList<String>();
                for (int i = 1; i < 12; i++) {
                    if (i != 2)
                        clients.add(rs.getString(i));
                }
                items.add(clients);
            }
        }catch (SQLException e){
            Logger lgr = Logger.getLogger(ReadingNET.class.getName());
            lgr.log(Level.WARNING, e.getMessage(), e);
        }
        return items;
    }

    public ArrayList<ArrayList<String>> searchBooks(String isbn, String title, String author, String readingLevel, String publisher, String genre, String status){
        ArrayList<ArrayList<String>> items = new ArrayList<ArrayList<String>>();
        String query = ("Select * FROM books WHERE ");
        boolean start = true;
        if(isbn != null) {
            start = false;
            query = query + "isbn LIKE '%" + isbn + "%'";
        }
        if (title != null){
            if (!start)
                query += " AND ";
            start = false;
            query = query + "title LIKE '%" + title.toLowerCase() +"%'";
        }
        if (author != null){
            if (!start)
                query += " AND ";
            start = false;
            query = query + "author LIKE '%" + author.toLowerCase() +"%'";
        }
        if (readingLevel != ""){
            if (!start)
                query += " AND ";
            start = false;
            query = query + "read_level LIKE '%" + readingLevel +"%'";
        }
        if (publisher != null){
            if (!start)
                query += " AND ";
            start = false;
            query = query + "publisher LIKE '%" + publisher.toLowerCase() +"%'";
        }
        if (genre != ""){
            if (!start)
                query += " AND ";
            start = false;
            query = query + "genre LIKE '%" + genre +"%'";
        }
        if (title != null){
            if (!start)
                query += " AND ";
            start = false;
            query = query + "status LIKE '%" + status +"%'";
        }


        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ArrayList<String> books = new ArrayList<String>();
                for (int j = 1; j < 8; j++) {
                    books.add(rs.getString(j));
                }
                items.add(books);
            }

        }catch (SQLException ex){
            Logger lgr = Logger.getLogger(ReadingNET.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);
        }
        return items;
    }

    public ArrayList<ArrayList<String>> searchTitles(String title){
        ArrayList<ArrayList<String>> items = new ArrayList<ArrayList<String>>();
        try {
            pst = con.prepareStatement("SELECT * FROM books WHERE title LIKE '%"+ title + "%'");
            rs = pst.executeQuery();
            while (rs.next()) {
                ArrayList<String> books = new ArrayList<String>();
                for (int j = 1; j < 8; j++) {
                    books.add(rs.getString(j));
                }
                items.add(books);
            }

        }catch (SQLException ex){
            Logger lgr = Logger.getLogger(ReadingNET.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);
        }
        return items;
    }

    public ArrayList<ArrayList<String>> showClients(){
        ArrayList<ArrayList<String>> items = new ArrayList<ArrayList<String>>();
        try {
            pst = con.prepareStatement("Select * FROM clients");
            rs = pst.executeQuery();
            while (rs.next()){
                ArrayList<String> clients = new ArrayList<String>();
                for (int i = 1; i < 12; i++){
                    if (i != 2)
                        clients.add(rs.getString(i));
                }
                items.add(clients);
            }
        }catch(SQLException e){
            Logger lgr = Logger.getLogger(ReadingNET.class.getName());
            lgr.log(Level.WARNING, e.getMessage(), e);
        }
        return items;
    }

    public void delete(String item, String type, String table){
        String del = item;
        try {
            pst = con.prepareStatement("DELETE FROM " + table + "WHERE " + type + "LIKE ?");
            pst.setString(1, del);
            pst.executeUpdate();
        }catch(SQLException ex){
            Logger lgr = Logger.getLogger(ReadingNET.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);
        }
    }

    public void insert(String item, String table, String type){
        String add = item;
        try{
            pst = con.prepareStatement("INSERT INTO " + table + "(" + type + ") " + "Values (?)");
            pst.setString(1, add);
            pst.executeUpdate();
        }catch(SQLException e){
            Logger lgr = Logger.getLogger(ReadingNET.class.getName());
            lgr.log(Level.WARNING, e.getMessage(), e);
        }
    }

    public void insertBook(String isbn, String title, String author, String readingLevel, String publisher, String genre, String status){
        try {
            pst = con.prepareStatement("INSERT INTO books Values (?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, isbn);
            pst.setString(2, title);
            pst.setString(3, author);
            pst.setString(4, readingLevel);
            pst.setString(5, publisher);
            pst.setString(6, genre);
            pst.setString(7, status);
            pst.executeUpdate();
        }catch(SQLException e){
            Logger lgr = Logger.getLogger(ReadingNET.class.getName());
            lgr.log(Level.WARNING, e.getMessage(), e);
        }
    }
    public void deleteBook(String isbn){
        try {
            pst = con.prepareStatement("DELETE FROM books WHERE isbn = ?");
            pst.setString(1, isbn);
            pst.executeUpdate();
        }catch(SQLException e){
            Logger lgr = Logger.getLogger(ReadingNET.class.getName());
            lgr.log(Level.WARNING, e.getMessage(), e);
        }
    }
}
