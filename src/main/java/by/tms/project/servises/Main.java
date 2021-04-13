package by.tms.project.servises;

import by.tms.project.dao.UserMemoryDAO;
import by.tms.project.entity.User;
import by.tms.project.exceptions.LoginDuplicateException;
import by.tms.project.exceptions.ParametersNotPassedException;

public class Main {
    public static void register(String login, String password) throws LoginDuplicateException, ParametersNotPassedException {
        if (login == null) throw new ParametersNotPassedException("login");
        if (password == null) throw new ParametersNotPassedException("password");
        UserMemoryDAO.getInstance().save(new User(login.trim(), password));
    }

    public static String getAllUsers() {
        String response = "Список зарегестрированых пользователей: <br><br>";
        response += "Id - Login - Password<br>";

        for (User user : UserMemoryDAO.getInstance().getAllUsers()) {
            response += String.format("%s - %s - %s <br>", user.getId(), user.getLogin(), user.getPassword());
        }
        return response;
    }
}
