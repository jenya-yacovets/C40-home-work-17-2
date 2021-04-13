package by.tms.project.dao;

import by.tms.project.entity.User;
import by.tms.project.exceptions.LoginDuplicateException;

import java.util.List;

public interface UsersDAO {
    int save(User user) throws LoginDuplicateException;
    List<User> getAllUsers();
}
