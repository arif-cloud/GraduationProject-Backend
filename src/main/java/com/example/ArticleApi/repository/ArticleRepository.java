package com.example.ArticleApi.repository;

import com.example.ArticleApi.model.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ArticleRepository extends MongoRepository<Article, String> {

    List<Article> findByTitleContainingIgnoreCase(String title);
    List<Article> findByTagsIn(String category, Pageable pageable);

}
