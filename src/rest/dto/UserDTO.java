package rest.dto;

import model.User;

/**
 * DTO of the user
 * the UserDto never contains the password
 * @author Julien Leroy & Loic Serafin
 */
public class UserDTO
{
    private int id = -1;
    private String userName;
    private String firstName;
    private String lastName;

    /**
     * Construct a UserDto from u user
     * @param user
     */
    public UserDTO(User user){
        id = user.getId();
        userName = user.getUserName();
        firstName = user.getFirstName();
        lastName = user.getLastName();

    }

    public UserDTO(){

    }

    public UserDTO(String userName, String fisrtName, String lastName){
        this.userName = userName;
        this.firstName = fisrtName;
        this.lastName = lastName;
    }

    /** Getters **/
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getUserName() { return userName; }
    public int getId(){ return id; }
}
