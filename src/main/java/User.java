/**
 * Created by alexpost1 on 4/9/15.
 */
public class User {
    private boolean volunteer;
    private String username;
    private String password;
    private boolean login;

    User(boolean vol, String user, String pass){
        volunteer = vol;
        username = user;
        password = pass;
        login = false;
    }

    public boolean getVolunteer(){
        return volunteer;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public boolean getLogin(){
        return login;
    }
}
