package com.example.ArticleApi.repository;

import com.example.ArticleApi.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
