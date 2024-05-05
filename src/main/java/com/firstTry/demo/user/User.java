package com.firstTry.demo.user;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CascadeType;
import org.springframework.context.annotation.Primary;

import com.firstTry.demo.posts.Post;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity(name="user_details")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private String password;
	private String about;
	
	@OneToMany(mappedBy = "user", cascade = jakarta.persistence.CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> post = new ArrayList();
	
	public List<Post> getPost() {
		return post;
	}

	public void setPosts(List<Post> post) {
		this.post = post;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String email, String password, String about) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", about=" + about
				+ "]";
	}
	
	
	
	
	
}