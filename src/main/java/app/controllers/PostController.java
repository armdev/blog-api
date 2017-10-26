package app.controllers;

import app.dao.PostDAO;
import app.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostDAO postDAO;

    /**
     * GET METHODS
     */
    @RequestMapping(method=RequestMethod.GET, value="/post/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable Long postId) {
        ResponseEntity<Post> res;

        // Find post by id
        Post post = postDAO.findOne(postId);

        if(post == null) {
            res = new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        } else {
            res = new ResponseEntity<Post>(post, HttpStatus.OK);
        }

        return res;
    }

    @RequestMapping(method=RequestMethod.GET, value="user/{userId}/post")
    public ResponseEntity<Iterable<Post>> getPostByUser(@PathVariable Long userId) {
        ResponseEntity<Iterable<Post>> res;

        // Find all post for given user
        List<Post> posts = postDAO.findByUserId(userId);

        if(posts == null) {
            res = new ResponseEntity<Iterable<Post>>(HttpStatus.NOT_FOUND);
        } else {
            res = new ResponseEntity<Iterable<Post>>(posts, HttpStatus.OK);
        }

        return res;
    }

    @RequestMapping(method=RequestMethod.GET, value="/post")
    public ResponseEntity<Iterable<Post>> getPosts() {
        ResponseEntity<Iterable<Post>> res;

        // Find all post
        Iterable<Post> posts = postDAO.findAll();

        if(posts == null) {
            res = new ResponseEntity<Iterable<Post>>(HttpStatus.NOT_FOUND);
        } else {
            res = new ResponseEntity<Iterable<Post>>(posts, HttpStatus.OK);
        }

        return res;
    }

    /**
     * POST METHODS
     */
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Post> newPost(@RequestBody Post p) {
        ResponseEntity<Post> res;

        Post post = postDAO.save(p);

        if(post == null) {
            res = new ResponseEntity<Post>(HttpStatus.BAD_REQUEST);
        } else {
            res = new ResponseEntity<Post>(post, HttpStatus.OK);
        }

        return res;
    }

    /**
     * PUT METHODS
     */

    /**
     * DELETE METHODS
     */
}
