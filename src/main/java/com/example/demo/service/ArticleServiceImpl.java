package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ArticleDAO;
import com.example.demo.model.Article;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleDAO dao;
	
	@Transactional
	@Override
	public List<Article> getArticle() 
	{
		List<Article> list=dao.getArticle();
		return list;
	}

	@Transactional
	@Override
	public void SaveArticle(Article article) 
	{
		dao.SaveArticle(article);
	}

	@Transactional
	@Override
	public void DeleteArticle(int id) 
	{
		dao.DeleteArticle(id);
	}

	@Transactional
	@Override
	public void UpdateArticle(int id,String Title,String Catg) 
	{
		dao.UpdateArticle(id, Title, Catg);
	}

	@Transactional
	@Override
	public Article getArticleObj(int id)
	{
		Article article=dao.getArticleObj(id);
		return article;
	}

}
