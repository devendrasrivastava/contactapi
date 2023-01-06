package in.stackroute.userprofile.service;

import in.stackroute.userprofile.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="jsonplaceholder", url = "https://jsonplaceholder.typicode.com/")
public interface APIFeignClient {

    @GetMapping("/posts/{postId}")
    public Post getPostsById(@PathVariable String postId);

    @GetMapping("/posts")
    public List<Post> getPosts();

}
