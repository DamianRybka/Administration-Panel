package Panel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/users")
public class UserController {

    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsers() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);


        return mapper.writeValueAsString(UserDao.getUsers());
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("post")
    public String post(@FormParam("name") String name) {
        System.out.println(name);
        return "Server says hello" + name + "!";
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("add")
    public User addUser(@FormParam("id") int id, @FormParam("name") String name, @FormParam("password") String password, @FormParam("email") String email) {
        User user = new User(id, name, password, email);
        System.out.println(user.toString());
        UserDao.addUser(user);
        return user;

    }

    public String updateUserEmail(int id, String email) {

        UserDao.updateUserEmail(id, email);

        return "email updated!";
    }

}
