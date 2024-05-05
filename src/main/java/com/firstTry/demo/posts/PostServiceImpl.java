package com.firstTry.demo.posts;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firstTry.demo.exceptions.ResourceNotFoundException;

@Component
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private PostDto pDto;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PostDto createPost(PostDto postDto) {
		// TODO Auto-generated method stub
		Post post=this.modelMapper.map(postDto, Post.class);
		//Post post = postDto.dtoToPost(postDto);
		Post createdPost = postRepo.save(post);
		//return postDto.postToDto(createdPost);
		return this.modelMapper.map(createdPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto,int id) {
		// TODO Auto-generated method stub
		Post post = postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("POST", "PostId", id));
		post.setId(id);
		if(postDto.getTitle()!=null)
			post.setTitle(postDto.getTitle());
		if(postDto.getImageName()!=null)
			post.setImageName(postDto.getImageName());
		if(postDto.getContent()!=null)
			post.setContent(postDto.getContent());
		
		post.setAddedDate(new Date(System.currentTimeMillis()));
		
		Post updatedService = postRepo.save(post);
		
		//return postDto.postToDto(updatedService);
		return this.modelMapper.map(updatedService, PostDto.class);
	}

	@Override
	public PostDto getPost(int id) {
		Post post = postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("POST", "PostId", id));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getAllPost() {
		List<Post> posts = postRepo.findAll();
		List<PostDto> dtoPosts = new ArrayList<PostDto>();
		for(Post p:posts) {
			dtoPosts.add(this.modelMapper.map(p, PostDto.class));
		}
		return dtoPosts;
	}

	@Override
	public void deletePost(int id) {
		// TODO Auto-generated method stub
		postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("POST", "PostId", id));
     
	}

}
