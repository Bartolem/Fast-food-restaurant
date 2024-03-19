package org.fast_food.authentication;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashingUtil {
    public static String hashPassword(String password) {
        // Generate a random salt
        String salt = BCrypt.gensalt();
        // Hash the password with the salt and return the hashed value
        return BCrypt.hashpw(password, salt);
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        // Check if the provided password matches the hashed password
        return BCrypt.checkpw(password, hashedPassword);
    }
}
