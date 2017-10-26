package app.dao;

import app.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostDAO extends CrudRepository<Post, Long>{
    List<Post> findByUserId(Long userId);
}