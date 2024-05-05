package com.firstTry.demo.posts;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface PostService {
	
	public  PostDto createPost(PostDto postDto);
	public  PostDto updatePost(PostDto postDto,int id);
	public  PostDto getPost(int id);
	public  List<PostDto> getAllPost();
	public  void deletePost(int id);
	
	

}
