package model;

/**
 * Model class of a user
 * @author Julien Leroy & Loic Serafin
 */
public class User
{
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private int id;

    /**
     * To construct a user without an id
     * @param firstName
     * @param lastName
     * @param userName
     * @param password
     */
    public User(String firstName, String lastName, String userName, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    /**
     * To construct a user with a id
     * @param id
     * @param firstName
     * @param lastName
     * @param userName
     * @param password
     */
    public User(int id, String firstName, String lastName, String userName, String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    /**
     * @param password
     * @return if pass word is right
     */
    public boolean checkPass(String password){
        if (password.equals(this.password)){
            return true;
        }

        return false;
    }

    /** Setters **/
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPassword(String password) { this.password = password; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    /** Getters **/
    public String getUserName(){
        return userName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getPassword() { return password; }
    public int getId(){ return id; }

}
