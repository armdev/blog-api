package app.service.post;

import app.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    List<Post> findAll(List<Long> postIds);
    Post find(Long postId);
    Boolean exists(Long postId);
    Post save(Post post);
    List<Post> save(List<Post> posts);
    void delete(Long postId);
}
