package com.example.ArticleApi.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "savedArticles")
public class SavedArticle {
    @Id
    private ObjectId _id;
    private String userId;
    private Article article;

    public SavedArticle() {

    }

    public SavedArticle(String userId, Article article) {
        this.userId = userId;
        this.article = article;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "SavedArticle{" +
                "userId='" + userId + '\'' +
                ", article=" + article +
                '}';
    }

}
