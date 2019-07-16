package com.example.demo.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;

@Controller
public class ArticleController {
	
	private static final Logger LOGGER = Logger.getLogger("ArticleController");

	@Autowired
	private ArticleService service;

	@RequestMapping("/")
	public String getmain(Model model) 
	{
		LOGGER.log(Level.INFO, "Inside Default Method of Mapping '/' ");
		LOGGER.log(Level.INFO, "---------------------------------");
		try 
		{
			List<Article> list=service.getArticle();
			model.addAttribute("list",list);
		}
		catch (Exception e) 
		{
			LOGGER.log(Level.WARNING, "ERROR OCCURED ["+e+"]");
		}
		LOGGER.log(Level.INFO, "---------------------------------");

		return "list.jsp";
	}
	
	@GetMapping("/list")
	public String getArticle(Model model)
	{
		LOGGER.log(Level.INFO, "Inside Method of Mapping '/list' ");
		LOGGER.log(Level.INFO, "---------------------------------");
		try 
		{
			List<Article> list=service.getArticle();
			model.addAttribute("list",list);
		}
		catch (Exception e) 
		{
			LOGGER.log(Level.WARNING, "ERROR OCCURED ["+e+"]");
		}
		LOGGER.log(Level.INFO, "---------------------------------");
		
		return "list.jsp";
	}
	
	@GetMapping("/savePage")
	public String SaveArticle() 
	{
		return "create.jsp";
	}
			
	@GetMapping("/save")
	public String SaveArticle(
			                  @RequestParam("a_title") String title,
			                  @RequestParam("a_catg") String catg,
			                  Model model
			                  ) 
	{
		LOGGER.log(Level.INFO, "Inside Method of Mapping '/save' ");
		LOGGER.log(Level.INFO, "---------------------------------");
		try 
		{
			Article at=new Article();
			at.setA_title(title);
			at.setA_category(catg);
			service.SaveArticle(at);
			
			List<Article> list=service.getArticle();
			model.addAttribute("list",list);
		}
		catch (Exception e) 
		{
			LOGGER.log(Level.WARNING, "ERROR OCCURED ["+e+"]");
		}
		LOGGER.log(Level.INFO, "---------------------------------");
		
		return "list.jsp";	
	}
	
	@GetMapping("/delete")
	public String DeleteArticle(@RequestParam("a_id") int id,Model model) 
	{
		LOGGER.log(Level.INFO, "Inside Method of Mapping '/delete' ");
		LOGGER.log(Level.INFO, "---------------------------------");
		try 
		{
			service.DeleteArticle(id);
			List<Article> list=service.getArticle();
			model.addAttribute("list",list);
		}
		catch (Exception e) 
		{
			LOGGER.log(Level.WARNING, "ERROR OCCURED ["+e+"]");
		}
		LOGGER.log(Level.INFO, "---------------------------------");
		
		return "list.jsp";
	}
	
	@GetMapping("/UpdatePage")
	public String updateArticle(@RequestParam("a_id") int id,Model model) 
	{
		LOGGER.log(Level.INFO, "Inside Method of Mapping '/UpdatePage' ");
		LOGGER.log(Level.INFO, "---------------------------------");
		try 
		{
			Article article=service.getArticleObj(id);
			model.addAttribute("aid", article.getA_id());
			model.addAttribute("atitle", article.getA_title());
			model.addAttribute("acatg", article.getA_category());
		}
		catch (Exception e) 
		{
			LOGGER.log(Level.WARNING, "ERROR OCCURED ["+e+"]");
		}
		LOGGER.log(Level.INFO, "---------------------------------");
	
		return "update.jsp";
	}
	
	@GetMapping("/update")
	public String UpdateArticle(
			                  @RequestParam("a_id") int id,
			                  @RequestParam("a_title") String title,
			                  @RequestParam("a_catg") String catg,
			                  Model model
			                  ) 
	{
		LOGGER.log(Level.INFO, "Inside Method of Mapping '/update' ");
		LOGGER.log(Level.INFO, "---------------------------------");
		try 
		{
			service.UpdateArticle(id,title,catg);
			List<Article> list=service.getArticle();
			model.addAttribute("list",list);
		}
		catch (Exception e) 
		{
			LOGGER.log(Level.WARNING, "ERROR OCCURED ["+e+"]");
		}
		LOGGER.log(Level.INFO, "---------------------------------");
		
		return "list.jsp";	
	}
	
	@GetMapping("/Search")
	public String SearchArticle(@RequestParam("id") int id) 
	{
		LOGGER.log(Level.INFO, "Inside Method of Mapping '/Search' ");
		LOGGER.log(Level.INFO, "---------------------------------");
		try 
		{
			Article article=service.getArticleObj(id);
		}
		catch (Exception e) 
		{
			LOGGER.log(Level.WARNING, "ERROR OCCURED ["+e+"]");
		}
		LOGGER.log(Level.INFO, "---------------------------------");
		
		return "list.jsp";
	}
	
}

