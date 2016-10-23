package rest.dto;

import model.User;

/**
 * @author jfleroy
 */
public class UserPasswordDTO extends UserDTO
{
    private String password;

    /**
     * Construct a UserPasswordDTO from u user
     *
     * @param user
     */
    public UserPasswordDTO(User user)
    {
        super(user);
        this.password = user.getPassword();
    }

    public UserPasswordDTO(){
        super();
    }

    /** Getter **/
    public String getPassword(){ return password; }

}
