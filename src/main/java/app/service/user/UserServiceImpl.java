package app.service.user;

import app.models.User;
import app.service.user.UserDAO;
import app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public List<User> findAll(List<Long> userIds) {
        return userDAO.findAll(userIds);
    }

    @Override
    public User find(Long userId) {
        return userDAO.findOne(userId);
    }

    @Override
    public Boolean exists(Long userId) {
        return userDAO.exists(userId);
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public List<User> save(List<User> users) {
        return userDAO.save(users);
    }

    @Override
    public void delete(Long userId) {
        userDAO.delete(userId);
    }
}
