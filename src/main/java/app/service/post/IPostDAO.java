package app.service.post;

import app.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostDAO extends JpaRepository<Post, Long> {}