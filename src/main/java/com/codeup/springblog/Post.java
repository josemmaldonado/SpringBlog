package com.codeup.springblog;
import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 1000)
    private String body;
//    @ManyToOne
    public Post() {
//        @ManyToOne(cascade = CascadeType.ALL, ) List<Post> postList;

    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(nullable = false, length = 255)
    private String title;
    @ManyToOne
    private User username;

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

//    @Service("mailService")
//    public class EmailService{
//        @Autowired
//        public JavaMailSender emailSender;
//        @Value("${spring.mail.from}")
//        private String from;
//
//        public void prepareAndSend( Post post, String subject, String body){
//            SimpleMailMessage msg = new SimpleMailMessage();
//            msg.setFrom(from);
//            msg.setTo(post.getUsername().getEmail());
//            msg.setSubject(subject);
//            msg.setText(body);
//
//            try{
//                this.email.Sender.send(msg);
//            }
//            catch (MailException ex) {
//                System.err.println(ex.getMessage());
//            }
//        }
//
//    }
}
