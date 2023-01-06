package in.stackroute.userprofile.controller;

import in.stackroute.userprofile.model.Post;
import in.stackroute.userprofile.service.APIFeignClient;
import in.stackroute.userprofile.service.ContactServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestFeignController {

    @Autowired
    private ContactServiceClient contactServiceClient;

    @Autowired
    private APIFeignClient apiFeignClient;

    @GetMapping("/api/v1/users/contacts/status")
    public String getContactInfo(){
        return  "From user service"+ contactServiceClient.getContactStatus();
    }

    @GetMapping("/api/v1/users/posts/{postId}")
    public Post getPostById (@PathVariable String postId){
        return apiFeignClient.getPostsById(postId);
    }

    @GetMapping("/api/v1/users/posts")
    public List<Post> getPosts (){
        return apiFeignClient.getPosts();
    }

}
