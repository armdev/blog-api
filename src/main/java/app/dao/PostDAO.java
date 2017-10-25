package app.dao;

import app.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostDAO extends CrudRepository<Post, Long>{}