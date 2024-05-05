package com.firstTry.demo.posts;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.firstTry.demo.category.Category;
import com.firstTry.demo.category.CategoryDto;
import com.firstTry.demo.user.User;
import com.firstTry.demo.user.UserDto;

@Component
public class PostDto {
	private int id;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	
  
	private CategoryDto category;
	private UserDto user;
	
	@Autowired
	private UserDto userDto;
	
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = new Date(System.currentTimeMillis());
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	
//	public Post dtoToPost(PostDto postDto)
//	{
//		Post post = new Post();
//		post.setId(postDto.getId());
//		post.setTitle(postDto.getTitle());
//		post.setImageName("defualt.img");
//		post.setContent(postDto.getContent());
//		post.setAddedDate(new Date(System.currentTimeMillis()));
//		post.setUser(postDto.getUser());
//		post.setCategory(postDto.getCategory());
//		
//		return post;
//	}
//	
//	public PostDto postToDto(Post post)
//	{
//		PostDto postDto = new PostDto();
//		postDto.setId(post.getId());
//		postDto.setTitle(post.getTitle());
//		postDto.setImageName(post.getImageName());
//		postDto.setContent(post.getContent());
//		postDto.setAddedDate(post.getAddedDate());
//		 
//		postDto.setUser(post.getUser());
//		postDto.setCategory(post.getCategory());
//		
//		return postDto;
//	}
	

}
