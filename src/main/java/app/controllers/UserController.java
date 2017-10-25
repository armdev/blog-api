package app.controllers;

import app.dao.UserDAO;
import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    /**
     * GET METHODS
     */
    @RequestMapping(method=RequestMethod.GET, value="/{userId}")
    public ResponseEntity<User> getUser(@PathVariable long userId) {
        // Response to return to client
        ResponseEntity<User> res;

        // Find user by Id from URL
        User user = userDAO.findOne(userId);

        if(user == null) {
            res = new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        } else {
            res = new ResponseEntity<User>(user, HttpStatus.OK);
        }

        return res;
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getUsers() {
        // Response to return to client
        ResponseEntity<Iterable<User>> res;

        // Find all users
        Iterable<User> users = userDAO.findAll();

        if(users == null) {
            res = new ResponseEntity<Iterable<User>>(HttpStatus.NOT_FOUND);
        } else {
            res = new ResponseEntity<Iterable<User>>(users, HttpStatus.OK);
        }

        return res;
    }

    /**
     * POST METHODS
     */
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<User> newUser(@RequestParam String email,
                          @RequestParam String password,
                          @RequestParam String firstName,
                          @RequestParam String lastName) {
        ResponseEntity<User> res;

        User user = userDAO.save(new User(email, password, firstName, lastName));

        if(user == null) {
            res = new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        } else {
            res = new ResponseEntity<User>(user, HttpStatus.OK);
        }

        return res;
    }

    /**
     * PUT METHODS
     */
    @RequestMapping(method=RequestMethod.PUT, value="/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable long userId,
                                           @RequestParam String email,
                                           @RequestParam String password,
                                           @RequestParam String firstName,
                                           @RequestParam String lastName) {
        ResponseEntity<User> res;

        User user = userDAO.save(new User(((Long) userId).intValue(), email, password, firstName, lastName));

        if(user == null) {
            res = new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        } else {
            res = new ResponseEntity<User>(user, HttpStatus.OK);
        }

        return res;
    }

    /**
     * DELETE METHODS
     */
    @RequestMapping(method=RequestMethod.DELETE, value="/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable long userId) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
