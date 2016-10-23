package dao;

import model.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * User DAO
 * @author Julien Leroy & Loic Serafin
 */
@Stateless
public class UserManager
{

    @Resource(lookup ="java:/amt")
    private DataSource dataSource;


    /**
     * @return the list of all the users in the database
     */
    public List<User> getAllUsers(){
        List<User> users = new LinkedList<>();

        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                users.add(new User(resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("userName"),
                        resultSet.getString("password")));
            }


        } catch (SQLException e){
            e.printStackTrace();
        }

        return users;
    }

    /**
     * @param id
     * @return the user with this id
     */
    public User getUser(int id){
        User user = null;
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                user = new User(resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("userName"),
                        resultSet.getString("password"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }


    /**
     * @param userName
     * @param password
     * @return true if the password matches the user name
     */
    public boolean checkUser(String userName, String password){

        List<User> users =  getAllUsers();

        for (User user : users){
            System.out.println(user.getUserName());
            if (user.getUserName().equals(userName)){
                if (user.checkPass(password))
                {
                    return true;
                }
                return false;
            }
        }
        return false;
    }


    /**
     * @param userName
     * @return return user id or -1 if user doesn't exist
     */
    public int getUserID(String userName){
        int userID = -1;
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT id FROM users WHERE userName = ?");
            statement.setString(1, userName);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                userID = resultSet.getInt("id");
            }

            System.out.println(userID);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return userID;
    }


    /**
     * create a user in the database
     * @param user
     * @return the new user id or -1 if it's fail
     */
    public int creatUser(User user){
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO `users` (`userName`, `password`, `firstName`, `lastName`) VALUES (?,?,?,?);" );

            System.out.println(user.getUserName());

            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());

            statement.execute();

            statement = connection.prepareStatement("SELECT id FROM users WHERE userName=?;");
            statement.setString(1, user.getUserName());

            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            return resultSet.getInt("id");

        } catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Delete the user with this id
     * @param id
     * @return true if successful
     */
    public boolean deleteUserID(int id){
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            statement.setInt(1, id);

            statement.execute();

            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Update the fisrtName of the id
     * @param id
     * @param firstName
     * @return true if successful
     */
    public boolean updateFirstName(int id, String firstName){
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET firstName = ? WHERE id = ?");
            statement.setString(1, firstName);
            statement.setInt(2, id);

            statement.execute();

            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Update the lastName of the id
     * @param id
     * @param lastName
     * @return true if successful
     */
    public boolean updatelastName(int id, String lastName){
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET lastName = ? WHERE id = ?");
            statement.setString(1, lastName);
            statement.setInt(2, id);

            statement.execute();

            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Update the password of the id
     * @param id
     * @param password
     * @return true if successful
     */
    public boolean updatePassword(int id, String password){
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET password = ? WHERE id = ?");
            statement.setString(1, password);
            statement.setInt(2, id);

            statement.execute();

            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

}
