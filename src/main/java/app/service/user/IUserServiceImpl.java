package app.service.user;

import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO IUserDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return IUserDAO.findAll();
    }

    @Override
    public List<User> findAll(List<Long> userIds) {
        return IUserDAO.findAll(userIds);
    }

    @Override
    public User find(Long userId) {
        return IUserDAO.findOne(userId);
    }

    @Override
    public Boolean exists(Long userId) {
        return IUserDAO.exists(userId);
    }

    @Override
    public User create(User userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        return IUserDAO.save(user);
    }

    @Override
    public User save(User user) {
        return IUserDAO.save(user);
    }

    @Override
    public List<User> save(List<User> users) {
        return IUserDAO.save(users);
    }

    @Override
    public void delete(Long userId) {
        IUserDAO.delete(userId);
    }
}
