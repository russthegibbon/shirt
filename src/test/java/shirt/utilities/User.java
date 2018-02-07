package shirt.utilities;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

public class User {
    private static User user = null;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private static final String configPath = "./config.json";
    private static final ConfigReader configReader = new ConfigReader(configPath);
    private static final Logger log = LogManager.getLogger("com.peppermintspencer");


    protected User() {
        JSONObject user = configReader.getValue("user");
        email = (String)user.get("email");
        password = (String)user.get("password");
    }

    public static User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }

    public void updateFirstName() {
        Faker faker = new Faker();
        // TODO: check whether there is a significant risk of the new name being the same as the old.
        firstName = faker.name().firstName();
    }

    public String firstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String lastName() {
        return lastName;
    }

    public String fullName() {
        if (firstName == null) {
            log.fatal("User's first name must be known in order to output full name.");
            return null;
        }
        if (lastName == null) {
            log.fatal("User's last name must be known in order to output full name.");
            return null;
        }
        return String.format("%s %s", firstName, lastName);
    }
}
