package app.service.user;

import app.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> findAll(List<Long> userIds);
    User find(Long userId);
    Boolean exists(Long userId);
    User save(User user);
    List<User> save(List<User> users);
    void delete(Long userId);
}
