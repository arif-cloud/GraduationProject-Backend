package com.example.ArticleApi.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "articles")
public class Article {
    @Id
    private ObjectId _id;
    private int id;
    private String url;
    private String title;
    private String imageUrl;
    private String publishDate;
    private List<String> tags;

    public Article() {

    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", tags=" + tags +
                '}';
    }
}
