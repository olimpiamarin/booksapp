package Model;

/**
 * Created by Voicu on 10/14/2016.
 */
public class User {

    private String username;
    private String password;

    public User (String username, String password) {
        this.password = password;
        this.username = username;
    }

    public void setUsername (String newUsername) {
        if (!username.equals(newUsername)) {
            username = newUsername;
        } else {
            System.out.println("Username incorrect");
        }
    }

    public String getUsername () {
        return this.username;
    }

    public void setPassword(String newPassord) {
        if(newPassord.length() < 6) {
            System.out.println("Not long enough");
        } else {
            this.password = newPassord;
        }
    }

    public String getPassword() {
        return this.password;
    }

    public String toString(){
        return "The user name is: " + getUsername() + ". The user password is: " + getPassword()+ ". haha";
    }

}
