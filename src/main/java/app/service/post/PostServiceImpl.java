package app.service.post;

import app.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements IPostService {

    @Autowired
    private IPostDAO IPostDAO;

    @Override
    public List<Post> findAll() {
        return IPostDAO.findAll();
    }

    @Override
    public List<Post> findAll(List<Long> postIds) {
        return IPostDAO.findAll(postIds);
    }

    @Override
    public Post find(Long postId) {
        return IPostDAO.findOne(postId);
    }

    @Override
    public Boolean exists(Long postId) {
        return IPostDAO.exists(postId);
    }

    @Override
    public Post save(Post post) {
        return IPostDAO.save(post);
    }

    @Override
    public List<Post> save(List<Post> posts) {
        return IPostDAO.save(posts);
    }

    @Override
    public void delete(Long postId) {
        IPostDAO.delete(postId);
    }
}
