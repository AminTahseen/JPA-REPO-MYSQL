package com.example.demo.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Article;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

	/* @Autowired will
	 * search for EntityManager object "em" in spring container 
	 * and use it as a dependency in ArticleDAOImpl class.
	 * */
	@Autowired
	private EntityManager em; 
	

	
	private static final Logger LOGGER = Logger.getLogger("ArticleDAOImpl");
	Session current;
	
	@Override
	public List<Article> getArticle() 
	{
		current=em.unwrap(Session.class);
		LOGGER.log(Level.INFO, "Session Created.");

		Query<Article> query=current.createQuery("from Article",Article.class);
		LOGGER.log(Level.INFO, "EXECUTED [ SELECT Query From tbl_article ]");
		
		List<Article> list=query.getResultList();
		LOGGER.log(Level.INFO, "Returning Resulted List");
		
		return list;
	}

	@Override
	public void SaveArticle(Article article) 
	{
		current=em.unwrap(Session.class);
		LOGGER.log(Level.INFO, "Session Created.");
		
		current.save(article);
		LOGGER.log(Level.INFO, "EXECUTED [ INSERT Query With Data["+article.toString()+"] on tbl_article ]");
		
	}

	@Override
	public void DeleteArticle(int id) 
	{
		current=em.unwrap(Session.class);
		LOGGER.log(Level.INFO, "Session Created.");
		
		Article article=current.get(Article.class, id);
		LOGGER.log(Level.INFO, "article found with data["+article.toString()+"]");
		
		current.delete(article);	
		LOGGER.log(Level.INFO, "EXECUTED [ DELETE Query on tbl_article ]");
	}

	@Override
	public void UpdateArticle(int id,String Title,String Catg) 
	{
		current=em.unwrap(Session.class);
		LOGGER.log(Level.INFO, "Session Created.");

		Article article=current.get(Article.class, id);
		LOGGER.log(Level.INFO, "article found with data["+article.toString()+"]");
		
		article.setA_title(Title);
		article.setA_category(Catg);
		LOGGER.log(Level.INFO, "Setting A_Title=["+Title+"] & A_Category=["+Catg+"]");
		
		current.update(article);
		LOGGER.log(Level.INFO, "EXECUTED [ UPDATE Query on tbl_article ]");
	}

	@Override
	public Article getArticleObj(int id) 
	{
		current=em.unwrap(Session.class);
		LOGGER.log(Level.INFO, "Session Created.");

		Article article=current.get(Article.class, id);
		LOGGER.log(Level.INFO, "article found with data["+article.toString()+"]");

		LOGGER.log(Level.INFO, "Returning Founded Article");
		return article;
		

	}

}
