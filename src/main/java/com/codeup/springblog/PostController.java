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

    public String individualPost(@PathVariable long id) {
        return "posts/show";
    }

    @GetMapping(path = "/posts/edit/{id}")
    public String editPost(@PathVariable long id, Model model){
        Post editPost = postDao.getById(id);
        model.addAttribute("postToEdit", editPost);

        return "posts/edit";

    }

    @PostMapping(path = "/posts/edit/")
    public String saveEditPost(@RequestParam(name="postId") long id,
                               @RequestParam(name="postTitle")String postTitle,
                               @RequestParam(name="postBody")String postBody,
                               Model model)
                               {
        Post editPost = postDao.getById(id);

        editPost.setBody(postBody);
        editPost.setTitle(postTitle);
        postDao.save(editPost);


        return "redirect:/posts";
    }


    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable Long id){
        long deletePostId = id;
        postDao.deleteById(deletePostId);
        return "redirect:/posts";
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
        return "redirect:/posts";
    }
}




