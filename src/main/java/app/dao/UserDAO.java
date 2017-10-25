package app.dao;

import app.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long>{}