package app.service.post;

import app.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDAO postDAO;

    @Override
    public List<Post> findAll() {
        return postDAO.findAll();
    }

    @Override
    public List<Post> findAll(List<Long> postIds) {
        return postDAO.findAll(postIds);
    }

    @Override
    public Post find(Long postId) {
        return postDAO.findOne(postId);
    }

    @Override
    public Boolean exists(Long postId) {
        return postDAO.exists(postId);
    }

    @Override
    public Post save(Post post) {
        return postDAO.save(post);
    }

    @Override
    public List<Post> save(List<Post> posts) {
        return postDAO.save(posts);
    }

    @Override
    public void delete(Long postId) {
        postDAO.delete(postId);
    }
}
