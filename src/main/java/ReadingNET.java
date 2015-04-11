import static spark.Spark.*;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerRoute;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadingNET {
    private static MySqlService db = null;
    private static boolean login = false;

    public static void main(String[] args) {
        get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                response.status(201);
                if (login)
                    response.redirect("/home");
                else
                    response.redirect("/login");
                return "";
            }
        });

        get(new FreeMarkerRoute("/login") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                Map<String, Object> data = new HashMap<String, Object>();
                data.put("templateName", "login.ftl");
                return modelAndView(data, "loginlayout.ftl");
            }
        });

        get(new FreeMarkerRoute("/logout"){
            @Override
            public ModelAndView handle(Request request, Response response){
                login = false;
                Map<String, Object> data = new HashMap<String, Object>();
                data.put("templateName", "logout.ftl");
                return modelAndView(data, "layout.ftl");
               }
        });

        post(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                String username = request.queryParams("username");
                String password = request.queryParams("password");
                db = new MySqlService(username, password);
                login = true;
                if (db.isConnected()) {
                    response.status(201);
                    response.redirect("/home");
                } else {
                    response.status(201);
                    response.redirect("/");
                }
                return "";
            }
        });

        get(new FreeMarkerRoute("/home") {
            public ModelAndView handle(Request request, Response response) {
                Map<String, Object> data = new HashMap<String, Object>();
                ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
                System.out.println(request.queryParams("search"));
                if(request.queryParams("search") == null) {
                    books = db.selectBooks("*", "Authors");
                }
                else {
                    books = db.searchBooks(request.queryParams("search"), request.queryParams("searchType"), "books");
                }

                if (login) {
                    data.put("Books", books);
                    data.put("templateName", "viewbook.ftl");
                } else
                    data.put("templateName", "logincheck.ftl");

                return modelAndView(data, "layout.ftl");
            }
        });

        get(new FreeMarkerRoute("/view") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                Map<String, Object> data = new HashMap<String, Object>();
                ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
                System.out.println(request.queryParams("search"));
                if(request.queryParams("search") == null) {
                    books = db.selectBooks("*", "Authors");
                }
                else {
                    books = db.searchBooks(request.queryParams("search"), request.queryParams("searchType"), "books");
                }

                if (login) {
                    data.put("Books", books);
                    data.put("templateName", "viewbook.ftl");
                } else
                    data.put("templateName", "logincheck.ftl");

                return modelAndView(data, "layout.ftl");
            }
        });

        get(new FreeMarkerRoute("/add") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                Map<String, Object> data = new HashMap<String, Object>();

                if (login)
                    data.put("templateName", "addauthor.ftl");
                else
                    data.put("templateName", "logincheck.ftl");

                return modelAndView(data, "layout.ftl");
            }
        });

        get(new FreeMarkerRoute("/clients"){
            @Override
            public ModelAndView handle(Request request, Response response){
                Map<String, Object> data = new HashMap<String, Object>();
                ArrayList<ArrayList<String>> clients = new ArrayList<ArrayList<String>>();

                if(request.queryParams("search") == null)
                    clients = db.showClients();
                else
                    clients = db.searchClients(request.queryParams("search"), request.queryParams("searchType"), "clients");


                if (login){
                    data.put("Clients", clients);
                    data.put("templateName", "clients.ftl");
                }
                else
                    data.put("templateName", "logincheck.ftl");

                return modelAndView(data, "layout.ftl");
            }
        });

        get(new FreeMarkerRoute("/delete") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                Map<String, Object> data = new HashMap<String, Object>();
                ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
                books = db.selectBooks("*", "Authors");
                if (login) {
                    data.put("Books", books);
                    data.put("templateName", "deletebook.ftl");
                }
                else
                    data.put("templateName", "logincheck.ftl");

                return modelAndView(data, "layout.ftl");
            }
        });

        get(new FreeMarkerRoute("/delete/:isbn") {
            public ModelAndView handle(Request request, Response response) {
                Map<String, Object> data = new HashMap<String, Object>();
                String isbn = request.params(":isbn");
                String title = db.selectBook("title", isbn);
                String author = db.selectBook("author", isbn);
                if (login) {
                    data.put("title", title);
                    data.put("author", author);
                    data.put("isbn", isbn);
                    data.put("templateName", "deletecheck.ftl");
                } else
                    data.put("templateName", "logincheck.ftl");

                return modelAndView(data, "layout.ftl");
            }
        });

        post(new Route("/delete/:isbn") {
            @Override
            public Object handle(Request request, Response response) {
                String isbn = request.params(":isbn");
                db.deleteBook(isbn);
                response.status(201);
                response.redirect("/delete");
                return "";
            }
        });

        post(new Route("/add") {
            @Override
            public Object handle(Request request, Response response) {
                String isbn = request.queryParams("isbn");
                String title = request.queryParams("title");
                String author = request.queryParams("author");
                String readingLevel = request.queryParams("readingLevel");
                String publisher = request.queryParams("publisher");
                String genre = request.queryParams("genre");
                String status = request.queryParams("status");

                db.insertBook(isbn, title, author, readingLevel, publisher, genre, status);
                response.status(201);
                response.redirect("/home");
                return "";
            }
        });

    }
}

