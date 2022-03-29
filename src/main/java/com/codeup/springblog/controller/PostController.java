package com.codeup.springblog.controller;
import com.codeup.springblog.Post;
import com.codeup.springblog.PostRepository;
import com.codeup.springblog.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

//    private final Post.EmailService emailService;
    private final PostRepository postDao;
    private final UserRepository userDao;


    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;

    }

//    public PostController (EmailService emailService){
//        this.emailService = emailService;
//    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

//


    @GetMapping(path = "/posts/{id}")

    public String individualPost(@PathVariable long id, Model model) {
        Post individualPost = postDao.getById(id);
        model.addAttribute("individualPost", individualPost);
        return "posts/show";
    }
//    @GetMapping(path = "/posts/create")
//    public String createPost( Model model) {
//        model.addAttribute("post", new Post());
//        return "posts/create";
//
//    }
    @GetMapping(path = "/posts/edit/{id}")
    public String editPost(@PathVariable long id, Model model){
        Post editPost = postDao.getById(id);
        model.addAttribute("postToEdit", editPost);

        return "posts/edit";

    }
//    @PostMapping(path = "/posts/create")
//    public String postCreate(@ModelAttribute Post post){
//        post.setUsername(userDao.getById(1L));
//        postDao.save(post);
//        return "redirect:/posts";
//    }
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
    public String createPost( Model model) {
        model.addAttribute("post", new Post());

        return "posts/create";


    }





    @PostMapping(path = "/posts/create")
    public String postCreate(@ModelAttribute Post post){
    post.setUsername(userDao.getById(1L));
    postDao.save(post);
        return "redirect:/posts";
    }



}




