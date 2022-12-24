package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDaoImpl implements UserDao {
    private final static List<User> users = new ArrayList<>();

    @Override
    public void saveUser(String name, String profession, String avatarURL, boolean hasBrains, int age) {
        users.add(new User(name, profession, avatarURL, hasBrains, age));
    }

    @Override
    public void updateUser(Long id, String name, String profession, String avatarURL, boolean hasBrains, int age) {
        users.forEach(user -> {
            if (Objects.equals(user.getId(), id)) {
                user.setAge(age);
                user.setAvatarURL(avatarURL);
                user.setHasBrains(hasBrains);
                user.setName(name);
                user.setProfession(profession);
            }
        });
    }

    @Override
    public void deleteUser(Long id) {
        users.removeIf(user -> Objects.equals(user.getId(), id));
    }

    @Override
    public void deleteUsers() {
        users.clear();
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public User getUserById(Long id) {
        for (User user: users) {
            if (Objects.equals(user.getId(), id)) return user;
        }

        return null;
    }
}
