package com.facebook.media.controller;

import com.facebook.media.entity.Comment;
import com.facebook.media.entity.Post;
import com.facebook.media.request.CreateCommentRequest;
import com.facebook.media.request.CreatePostRequest;
import com.facebook.media.response.PostResponse;
import com.facebook.media.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/createPost")
    public PostResponse createPost(@RequestBody CreatePostRequest createPostRequest) {
        return postService.createPost(createPostRequest);

    }
    @PostMapping("/createComment")
    public Comment commentPost(@RequestBody CreateCommentRequest createCommentRequest){
        return postService.commentOnPost(createCommentRequest);
    }

//   @GetMapping("/getPost/{id}")
//   public Post getPostByPostId(@PathVariable(name = "id") String postId, String userId){
//        return postService.getPostByPostId(postId, userId);
//   }

   @DeleteMapping("/deletePost")
   public String deletePost(@PathVariable(name = "id") String postId )
   {
        return postService.delete(postId);
   }


}
