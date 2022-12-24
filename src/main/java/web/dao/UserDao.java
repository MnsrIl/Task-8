package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(String name, String profession, String avatarURL, boolean hasBrains, int age);

    void updateUser(Long id, String name, String profession, String avatarURL, boolean hasBrains, int age);

    void deleteUser(Long id);

    void deleteUsers();

    List<User> getUsers();

    User getUserById(Long id);
}
