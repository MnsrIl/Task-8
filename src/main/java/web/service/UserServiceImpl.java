package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void createUser(String name, String profession, String avatarURL, boolean hasBrains, int age) {
        userDao.saveUser(name, profession, avatarURL, hasBrains, age);
    }

    @Override
    public void updateUser(Long id, String name, String profession, String avatarURL, boolean hasBrains, int age) {
        userDao.updateUser(id, name, profession, avatarURL, hasBrains, age);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public void deleteUsers() {
        userDao.deleteUsers();
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUserById(Long id) {
        return id == null ? null : userDao.getUserById(id);
    }
}
