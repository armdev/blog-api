package main;

import app.controllers.PostController;
import app.exceptions.BadRequestException;
import app.exceptions.NoContentException;
import app.models.Post;
import app.models.User;
import app.service.post.IPostService;
import app.service.user.IUserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PostControllerTest {

    private IPostService postService;

    private IUserService userService;

    private PostController postController;

    @Before
    public void initialize() {
        this.userService = Mockito.mock(IUserService.class);

        this.postService = Mockito.mock(IPostService.class);

        this.postController = new PostController(userService, postService);
    }

    @Test
    public void getPost_Success() {
        // Setup
        Long id = Long.valueOf("123");
        Post post = new Post(id);
        Mockito.when(postService.find(id)).thenReturn(post);

        // Lets try this out
        Post res = this.postController.getPost(id);

        // What did we get?
        Assert.assertEquals("Expect post with same id to be returned", post.getId(), res.getId());
    }

    @Test(expected = BadRequestException.class)
    public void getPost_Failure() {
        // Setup
        Long id = Long.valueOf("123");
        Mockito.when(postService.find(id)).thenReturn(null);

        // Call it
        this.postController.getPost(id);
    }

    @Test
    public void getPosts_Success() {
        // Setup
        Long id = Long.valueOf("123");
        List<Post> posts = new ArrayList<Post>(Arrays.asList(new Post(id)));
        Mockito.when(postService.findAll()).thenReturn(posts);

        // Test
        List<Post> res = this.postController.getPosts();

        // Validate
        Assert.assertEquals("Only one returned", 1, res.size());
        Assert.assertEquals("Expect ids to match", id, posts.get(0).getId());
    }

    @Test(expected = NoContentException.class)
    public void getPosts_Failure() {
        // Setup
        Mockito.when(postService.findAll()).thenReturn(null);

        // Test
        this.postController.getPosts();
    }

    @Test
    public void getPostsByUser_Success() {
        // Setup
        Long id = Long.valueOf("123");

        List<Post> posts = new ArrayList<Post>(Arrays.asList(new Post(id)));

        User user = new User(id);
        user.setPosts(posts);

        Mockito.when(userService.find(id)).thenReturn(user);

        // Test
        List<Post> res = this.postController.getPostsByUser(id);

        // Validate
        Assert.assertEquals("Only one returned", 1, res.size());
        Assert.assertEquals("Expect ids to match", id, posts.get(0).getId());
    }

    @Test(expected = BadRequestException.class)
    public void getPostsByUser_Failure_BadUser() {
        // Setup
        Long id = Long.valueOf("123");
        Mockito.when(userService.find(id)).thenReturn(null);

        // Test
        this.postController.getPostsByUser(id);
    }

    @Test(expected = NoContentException.class)
    public void getPostsByUseR_Failure_NoContent() {
        // Setup
        Long id = Long.valueOf("123");

        User user = new User(id);
        user.setPosts(new ArrayList<Post>());

        Mockito.when(userService.find(id)).thenReturn(user);

        // Test
        this.postController.getPostsByUser(id);
    }
}
