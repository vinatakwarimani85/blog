package com.firstTry.demo.posts;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstTry.demo.user.UserDto;

import jakarta.validation.Valid;

@RestController
public class postControler {

	@Autowired
	private PostService postService;
	
	@PostMapping("/create-post")
	public ResponseEntity<PostDto> create(@RequestBody PostDto postDto){
		PostDto createdPost = postService.createPost(postDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
	}
	
	@PutMapping("/update-post")
	public ResponseEntity<PostDto> update(@RequestBody PostDto postDto){
		int id = postDto.getId();
		PostDto updatePost=postService.updatePost(postDto, id);
		return ResponseEntity.status(HttpStatus.CREATED).body(updatePost);
	}
	
	
	@GetMapping("/get-all-posts")
	public ResponseEntity<List<PostDto>> getAllPost(){
		List<PostDto> posts=postService.getAllPost();
		return ResponseEntity.status(HttpStatus.OK).body(posts);
	}
	
	@GetMapping("/get-post")
	public ResponseEntity<PostDto> getPost(@RequestBody PostDto postDto){
		int id = postDto.getId();
		PostDto post=postService.getPost(id);
		return ResponseEntity.status(HttpStatus.OK).body(post);
	}
	
	@DeleteMapping("/delte-post")
	public ResponseEntity<?> deleteUser(@RequestBody PostDto postDto){
		int id = postDto.getId();
		postService.deletePost(id);
		return new ResponseEntity(Map.of("message","post deleted sucessfully"),HttpStatus.OK);
	}
	
	
}
