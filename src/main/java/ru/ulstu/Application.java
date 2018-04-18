package ru.ulstu;

import ru.ulstu.entity.User;
import ru.ulstu.exception.UserNotValidException;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = new User(1L, "somelogin");
        User newUser = new User("newlogin");
        try {
            userService.saveUser(user);
            userService.getUsers();
            userService.saveUser(newUser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UserNotValidException e) {
            e.printStackTrace();
        }
    }
}
