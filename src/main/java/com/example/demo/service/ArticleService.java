package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Article;

public interface ArticleService {
	
	
	List<Article> getArticle();
	
	void SaveArticle(Article article);
	
	void DeleteArticle(int id);
	
	void UpdateArticle(int id,String Title,String Catg);
	
	Article getArticleObj(int id);

}
