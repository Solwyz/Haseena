package com.solwyz.haseena.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Blog {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String title;
//	@Column(length = 5000)
//	private String shortDescription;
//	@Column(length = 5000)
//	private String blogShortDescription;
	@Lob
	@Column(columnDefinition = "TEXT")
	private String shortDescription;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String blogShortDescription;

	private String image;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


	
	public Blog() {
		super();
		
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getBlogShortDescription() {
		return blogShortDescription;
	}
	public void setBlogShortDescription(String blogShortDescription) {
		this.blogShortDescription = blogShortDescription;
	}

	
}
