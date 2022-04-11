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

    public ArticleServiceImpl() {
        try(BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(", ");
                Article article = new Article((int)id.incrementAndGet(), values[0], values[1], values[2], values[3], Boolean.parseBoolean(values[4]), values[5], values[6]);
                articles.put(id.intValue(), article);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createArticle(Article article) {   
        if(articles.containsKey(article.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Article already exists");

        articles.put(article.getId(), article);
    }

    @Override
    public void updateArticle(Integer id, Article article) {
        articles.remove(id);
        article.setId(id);
        articles.put(article.getId(), article);
    }

    @Override
    public void deleteArticle(Integer id) {
        articles.remove(id);
    }

    @Override
    public Collection<Article> getArticles() {
        return articles.values();
    }

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
            case "availability": for(Map.Entry<Integer, Article> el : articles.entrySet()) {
                if(el.getValue().getAvailability()) {
                    filteredArticles.put((int)counter.incrementAndGet(), el.getValue());
                }
            } break;
            default: System.out.println("You've messed something up really bad if you are seeing this lol");
        } 
        return filteredArticles.values();
    }
}
