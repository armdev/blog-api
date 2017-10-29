package app.controllers;

import app.config.patch.json.Patch;
import app.config.patch.json.PatchRequestBody;
import app.controllers.exceptions.BadRequestException;
import app.controllers.exceptions.NoContentException;
import app.models.Post;
import app.models.User;
import app.service.post.PostService;
import app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    /**
     * GET METHODS
     */
    @RequestMapping(method=RequestMethod.GET, value = "/posts/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Post getPost(@PathVariable Long id) {
        Post post = postService.find(id);

        if(post == null) {
            throw new BadRequestException();
        }

        return post;
    }

    @RequestMapping(method=RequestMethod.GET, value = "/posts")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Post> getPosts() {
        List<Post> posts = postService.findAll();

        if(posts.isEmpty()) {
            throw new NoContentException();
        }

        return posts;
    }


    @RequestMapping(method=RequestMethod.GET, value = "/users/{id}/posts")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Post> getPostsByUser(@PathVariable Long id) {
        // Check user is valid
        User user = userService.find(id);
        if(user == null) {
            throw new BadRequestException();
        }

        // Check user has posts
        List<Post> posts = user.getPosts();
        if(posts.isEmpty()) {
            throw new NoContentException();
        }

        return posts;
    }

    /**
     * POST METHODS
     */
    @RequestMapping(method=RequestMethod.POST, value = "/users/{id}/posts")
    @ResponseStatus(value = HttpStatus.OK)
    public Post newPost(@PathVariable Long id, @RequestBody Post post) {

        if(!userService.exists(id)) {
            throw new BadRequestException();
        }

        post.setUser(new User(id));
        return postService.save(post);
    }

    /**
     * PUT/PATCH METHODS
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/posts/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {

        if(!postService.exists(id)) {
            throw new BadRequestException();
        }

        post.setId(id);
        return postService.save(post);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/posts/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @Patch(service = PostService.class, id = Long.class)
    public Post patchPost(@PathVariable Long id, @PatchRequestBody Post post) {

        if(!postService.exists(id)) {
            throw new BadRequestException();
        }

        post.setId(id);
        return postService.save(post);
    }

    /**
     * DELETE METHODS
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/posts/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deletePost(@PathVariable Long id) {

        if(!postService.exists(id)) {
            throw new BadRequestException();
        }

        postService.delete(id);
    }

}
