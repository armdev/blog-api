package app.controllers;

import app.dao.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostDAO postDAO;

    /**
     * GET METHODS
     */

    /**
     * POST METHODS
     */

    /**
     * PUT METHODS
     */

    /**
     * DELETE METHODS
     */
}
