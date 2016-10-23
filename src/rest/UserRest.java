package rest;

import dao.UserManager;
import model.User;
import rest.dto.UserDTO;
import rest.dto.UserPasswordDTO;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static javax.ws.rs.core.Response.ok;

/**
 * REST API interation with the users datas
 * @author Julien Leroy & Loic Serafin
 */

@Path("/user")
public class UserRest
{
    @Context
    private UriInfo uriInfo;

    
    @EJB
    private UserManager userManager;

    /**
     * @return List with the users DTO
     */
    @GET
    public Response getUsers(){
        List<User> users = userManager.getAllUsers();

        return ok(users.stream().map(UserDTO::new).collect(Collectors.toList()), MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam(value = "id") int id){

        User user = userManager.getUser(id);

        if (user == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(new UserDTO(user), MediaType.APPLICATION_JSON).build();
        }
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(UserPasswordDTO user)
    {
        String userName = user.getUserName();
        String password = user.getPassword();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        if (userName == null || password == null || firstName == null || lastName == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            int userId = userManager.creatUser(new User(firstName, lastName, userName, password));
            System.out.println(userId);
            if (userId != -1){

                URI href = uriInfo.getBaseUriBuilder()
                        .path(UserRest.class)
                        .path(UserRest.class, "getUser")
                        .build(userId);

                return Response.created(href).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Already Exist").build();

            }
        }



    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam(value = "id") int id, UserPasswordDTO userPasswordDTO){

        if(userManager.getUser(id) != null)
        {
            if (userPasswordDTO.getUserName() != null){
                return Response.status(Response.Status.BAD_REQUEST).build();
            }

            if (userPasswordDTO.getId() != -1){
                return Response.status(Response.Status.BAD_REQUEST).build();
            }

            if (userPasswordDTO.getFirstName() != null)
            {
                if (!userManager.updateFirstName(id, userPasswordDTO.getFirstName()))
                {
                    return Response.serverError().build();
                }

            }

            if (userPasswordDTO.getLastName() != null)
            {
                if (!userManager.updatelastName(id, userPasswordDTO.getLastName()))
                {
                    return Response.serverError().build();
                }
            }


            if (userPasswordDTO.getPassword() != null)
            {
                if (!userManager.updatePassword(id, userPasswordDTO.getPassword()))
                {
                    return Response.serverError().build();
                }
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().build();
    }




    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam(value = "id") int id){

        if (userManager.getUser(id) != null)
        {

            if (userManager.deleteUserID(id))
            {
                return Response.ok().build();
            } else
            {
                return Response.serverError().build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}
