package Panel;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    static List<User> users = new ArrayList<>();

    public static List<User> getUsers() {

        users.add(new User(1,"John", "Doe", "john74@gmail.com"));
        users.add(new User(2,"Carl", "Dudidu", "carl69@gmail.com"));

        return users;
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static void updateUserEmail(int id, String email) {
        users.get(id).setEmail(email);

    }

    public static void deleteUser(int id) {
        users.remove(id);
    }
}
