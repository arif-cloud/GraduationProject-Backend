package com.example.ArticleApi.repository;

import com.example.ArticleApi.model.SavedArticle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SavedArticleRepository extends MongoRepository<SavedArticle, String> {
    List<SavedArticle> findByUserId(String userId);
    boolean existsByUserIdAndArticleId(String userId, int articleId);
    SavedArticle findByUserIdAndArticleId(String userId, int articleId);

}
