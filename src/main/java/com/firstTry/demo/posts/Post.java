package com.firstTry.demo.posts;

import java.sql.Date;

import javax.xml.crypto.Data;

import org.hibernate.annotations.ManyToAny;

import com.firstTry.demo.category.Category;
import com.firstTry.demo.user.User;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
	
    @Id
    @GeneratedValue
	private int id;
    
    @Column(length = 50)
	private String title;
    
    @Column(length = 1000)
	private String content;
	
	private String imageName;
	private Date addedDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "category_id")
    private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "id")
	private User user;

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

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
