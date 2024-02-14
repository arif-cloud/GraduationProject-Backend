package com.example.ArticleApi.repository;

import com.example.ArticleApi.model.PopularArticle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PopularArticleRepository extends MongoRepository<PopularArticle, String> {
}
