package com.example.project.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.example.project.Model.Article;
import com.example.project.Service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public ResponseEntity<Object> getArticles() throws FileNotFoundException, IOException {
        return new ResponseEntity<>(articleService.getArticles(), HttpStatus.OK);
    }

    @RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteArticle(@PathVariable("id") Integer id){
        articleService.deleteArticle(id);
        return new ResponseEntity<>("Article has been deleted.", HttpStatus.OK);
    }

    @RequestMapping(value = "/articles/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>updateArticle(@PathVariable("id") Integer id, @RequestBody Article article){
        articleService.updateArticle(id, article);
        return new ResponseEntity<>("Article has been updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    public ResponseEntity<Object>createArticle(@RequestBody Article article){
        articleService.createArticle(article);
        return new ResponseEntity<>("Article has been added successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/articles/{filterType}/{filter}", method = RequestMethod.GET)
    public ResponseEntity<Object>getFilteredArticles(@PathVariable("filterType") String filterType, @PathVariable("filter") String filter){
        return new ResponseEntity<>(articleService.getFilteredArticles(filterType, filter), HttpStatus.OK);
    }
}
