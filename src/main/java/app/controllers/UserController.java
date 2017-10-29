package app.controllers;

import app.config.patch.json.Patch;
import app.config.patch.json.PatchRequestBody;
import app.controllers.exceptions.BadRequestException;
import app.controllers.exceptions.NoContentException;
import app.service.user.UserService;
import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * GET METHODS
     */
    @RequestMapping(method=RequestMethod.GET, value = "/users/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    public User getUser(@PathVariable Long userId) {
        User user = userService.find(userId);

        if(user == null) {
            throw new NoContentException();
        }

        return user;
    }

    @RequestMapping(method=RequestMethod.GET, value = "/users")
    @ResponseStatus(value = HttpStatus.OK)
    public List<User> getUsers() {
        List<User> users = userService.findAll();

        if(users.isEmpty()) {
            throw new NoContentException();
        }

        return users;
    }

    /**
     * POST METHODS
     */
    @RequestMapping(method=RequestMethod.POST, value = "/users")
    @ResponseStatus(value = HttpStatus.OK)
    public User newUser(@RequestBody User user) throws BadRequestException {
        return userService.save(user);
    }

    /**
     * PUT/PATCH METHODS
     */
    @RequestMapping(method=RequestMethod.PUT, value = "/users/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    public User updateUser(@PathVariable Long userId, @RequestBody User user) throws BadRequestException {
        user.setId(userId);
        return userService.save(user);
    }

    @RequestMapping(method=RequestMethod.PATCH, value = "/users/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @Patch(service = UserService.class, id = Long.class)
    public User patchUser(@PathVariable Long id, @PatchRequestBody User user) throws BadRequestException {
        user.setId(id);
        return userService.save(user);
    }

    /**
     * DELETE METHODS
     */
    @RequestMapping(method=RequestMethod.DELETE, value = "/users/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteUser(@PathVariable long userId) {
        userService.delete(userId);
    }
}
