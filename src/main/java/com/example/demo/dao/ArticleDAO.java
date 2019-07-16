package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Article;

public interface ArticleDAO {
	
	List<Article> getArticle();
	
	void SaveArticle(Article article);
	
	void DeleteArticle(int id);
	
	void UpdateArticle(int id,String Title,String Catg);
	
	Article getArticleObj(int id);
}
