package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="tbl_article")
public class Article {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int a_id;
	
	@Column
	private String a_title;
	
	@Column
	private String a_category;
	
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_title() {
		return a_title;
	}
	public void setA_title(String a_title) {
		this.a_title = a_title;
	}
	public String getA_category() {
		return a_category;
	}
	public void setA_category(String a_category) {
		this.a_category = a_category;
	}
	@Override
	public String toString() {
		return "a_id=" + a_id + ", a_title=" + a_title + ", a_category=" + a_category +"";
	}
	
	
	

}
