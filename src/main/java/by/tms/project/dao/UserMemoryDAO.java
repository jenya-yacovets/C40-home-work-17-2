package by.tms.project.dao;

import by.tms.project.entity.User;
import by.tms.project.exceptions.LoginDuplicateException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMemoryDAO implements UsersDAO{
    private static UserMemoryDAO instance;
    private int nextId;
    private Map<Integer, User> userMap;

    private UserMemoryDAO() {
        userMap = new HashMap<>();
        nextId = 1;
    }

    public static UserMemoryDAO getInstance() {
        if(instance == null) {
            instance = new UserMemoryDAO();
        }
        return instance;
    }

    @Override
    public int save(User user) throws LoginDuplicateException {

        for(User item : userMap.values()) {
            if(item.getLogin().equals(user.getLogin())) {
                throw new LoginDuplicateException();
            }
        }

        user.setId(nextId);
        userMap.put(nextId, user);
        nextId++;
        return user.getId();
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }
}
