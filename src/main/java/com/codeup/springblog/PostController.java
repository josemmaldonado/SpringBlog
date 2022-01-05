package com.codeup.springblog;
import javax.persistence.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {


    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

//


    @GetMapping(path = "/posts/{id}")

    public String individualPost() {
        return "view an individual post";
    }

    @GetMapping(path = "/posts/create")
    public String createPost() {

        return "posts/create";

    }

    @PostMapping(path = "/posts/create")
    public String postCreate(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        return "posts/index";
    }
}




