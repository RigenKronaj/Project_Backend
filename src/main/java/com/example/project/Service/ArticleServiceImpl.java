package com.example.project.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.example.project.Model.Article;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ArticleServiceImpl implements ArticleService {
    private static Map<Integer, Article> articles = new HashMap<Integer, Article>();
    private final AtomicLong id = new AtomicLong();

    /**
     * The class' constructor, in which data is read from the CSV file and stored
     * into a HashMap
     */
    public ArticleServiceImpl() {
        try(BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(", ");
                Article article = new Article((int)id.incrementAndGet(), values[0], values[1], values[2], values[3], Boolean.parseBoolean(values[4]), values[5], values[6], values[7]);
                articles.put(id.intValue(), article);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    /** 
     * @param article
     * <br/>
     * This method is used to add a new article to the hashmap
     */
    @Override
    public void createArticle(Article article) {   
        if(articles.containsKey(article.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Article already exists");

        articles.put(article.getId(), article);
    }

    
    /** 
     * @param id
     * @param article
     * <br/>
     * This method is called to edit an already existing article
     */
    @Override
    public void updateArticle(Integer id, Article article) {
        articles.remove(id);
        article.setId(id);
        articles.put(article.getId(), article);
    }

    
    /** 
     * @param id
     * <br/>
     * This method is used to delete an article from the hashmap based on the ID provided
     */
    @Override
    public void deleteArticle(Integer id) {
        articles.remove(id);
    }

    
    /** 
     * @return Collection<Article>
     * <br/>
     * This method simply returns the entries in the hashmap in the form of an array
     */
    @Override
    public Collection<Article> getArticles() {
        return articles.values();
    }

    
    /** 
     * @return Collection<Article>
     * <br/>
     * This method is used to filter the entries from the hashmap into a new temporary hashmap
     * which will only contain articles that are available. It then returns the entries of this new
     * hashmap in the form of an array
     */
    @Override
    public Collection<Article> getAvailableArticles() {
        Map<Integer, Article> availableArticles = new HashMap<Integer, Article>();
        AtomicLong counter = new AtomicLong();

        for(Map.Entry<Integer, Article> el : articles.entrySet()) {
            if(el.getValue().getAvailability())
                availableArticles.put((int)counter.incrementAndGet(), el.getValue());
        }

        return availableArticles.values();
    }

    /**
     * @param id
     * @return Object
     * <br/>
     * This method is used to retrieve a single article from the hashmap
     */
    @Override
    public Object getSingleArticle(Integer id) {
        return articles.get(id);
    }

    
    /** 
     * @param filterType
     * @param filter
     * @return Collection<Article>
     * <br/>
     * This method is used to retrieve an array that consists of a filtered set of articles
     * with the filtertype and filter provided by the user in the frontend
     */
    @Override
    public Collection<Article> getFilteredArticles(String filterType, String filter) {
        Map<Integer, Article> filteredArticles = new HashMap<Integer, Article>();
        AtomicLong counter = new AtomicLong();
        switch(filterType) {
            case "title": for(Map.Entry<Integer, Article> el : articles.entrySet()) {
                if(el.getValue().getTitle().toLowerCase().contains(filter.toLowerCase()))
                    filteredArticles.put((int)counter.incrementAndGet(), el.getValue());
            } break;
            case "author": for(Map.Entry<Integer, Article> el : articles.entrySet()) {
                if(el.getValue().getAuthor().toLowerCase().contains(filter.toLowerCase()))
                    filteredArticles.put((int)counter.incrementAndGet(), el.getValue());
            } break;
            case "genre": for(Map.Entry<Integer, Article> el : articles.entrySet()) {
                if(el.getValue().getGenre().toLowerCase().contains(filter.toLowerCase()))
                    filteredArticles.put((int)counter.incrementAndGet(), el.getValue());
            } break;
            case "type": for(Map.Entry<Integer, Article> el : articles.entrySet()) {
                if(el.getValue().getType().toLowerCase().contains(filter.toLowerCase()))
                    filteredArticles.put((int)counter.incrementAndGet(), el.getValue());
            } break;
            default: System.out.println("Unknown value");
        } 
        return filteredArticles.values();
    }

    
    /** 
     * @param filterType
     * @param filter
     * @return Collection<Article>
     * <br/>
     * This method is used to retrieve an array that consists of a filtered set of articles
     * with the filtertype and filter provided by the user in the frontend, but are also available
     */
    @Override
    public Collection<Article> getFilteredAvailableArticles(String filterType, String filter) {
        Map<Integer, Article> filteredArticles = new HashMap<Integer, Article>();
        AtomicLong counter = new AtomicLong();
        switch(filterType) {
            case "title": for(Map.Entry<Integer, Article> el : articles.entrySet()) {
                if(el.getValue().getTitle().toLowerCase().contains(filter.toLowerCase()) && el.getValue().getAvailability())
                    filteredArticles.put((int)counter.incrementAndGet(), el.getValue());
            } break;
            case "author": for(Map.Entry<Integer, Article> el : articles.entrySet()) {
                if(el.getValue().getAuthor().toLowerCase().contains(filter.toLowerCase()) && el.getValue().getAvailability())
                    filteredArticles.put((int)counter.incrementAndGet(), el.getValue());
            } break;
            case "genre": for(Map.Entry<Integer, Article> el : articles.entrySet()) {
                if(el.getValue().getGenre().toLowerCase().contains(filter.toLowerCase()) && el.getValue().getAvailability())
                    filteredArticles.put((int)counter.incrementAndGet(), el.getValue());
            } break;
            case "type": for(Map.Entry<Integer, Article> el : articles.entrySet()) {
                if(el.getValue().getType().toLowerCase().contains(filter.toLowerCase()) && el.getValue().getAvailability())
                    filteredArticles.put((int)counter.incrementAndGet(), el.getValue());
            } break;
            default: System.out.println("Unknown value");
        } 
        return filteredArticles.values();
    }
}
