package com.firstTry.demo.category;

import java.util.ArrayList;
import java.util.List;

import com.firstTry.demo.posts.Post;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private  int categoryId;

    @Column(name ="title")
    private  String categoryTitle;

    @Column(name = "description")
    private   String categoryDiscription;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    public List<Post> getPost() {
		return posts;
	}

	public void setPost(List<Post> post) {
		this.posts = post;
	}

	public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public String getCategoryDiscription() {
        return categoryDiscription;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setCategoryDiscription(String categoryDiscription) {
        this.categoryDiscription = categoryDiscription;
    }
}
