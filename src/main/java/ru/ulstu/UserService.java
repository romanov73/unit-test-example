package ru.ulstu;

import ru.ulstu.entity.User;
import ru.ulstu.exception.UserNotValidException;
import ru.ulstu.persistence.DbStore;
import ru.ulstu.persistence.FileStore;
import ru.ulstu.persistence.PersistentStore;
import ru.ulstu.util.PropertyManager;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private PersistentStore<User> persistentStore;
    PropertyManager propertyManager = PropertyManager.getInstance();

    public UserService(PersistentStore<User> persistentStore) {
        this.persistentStore = persistentStore;
    }

    public UserService() {
        persistentStore = propertyManager.getTargetStorage().equals("file")
                ? new FileStore(User.class)
                : new DbStore(User.class);
    }

    public User saveUser(User user) throws UserNotValidException, IOException {
        validateUser(user);
        return persistentStore.save(user);
    }

    public List<User> getUsers() throws IOException {
        return persistentStore.readAll()
                .stream()
                .limit(10)
                .collect(Collectors.toList());
    }

    private void validateUser(User user) throws UserNotValidException {
        if (user.getLogin() == null || user.getLogin().equals("")) {
            throw new UserNotValidException("Пустой логин", UserNotValidException.Code.EMPTY_LOGIN);
        }
    }
}