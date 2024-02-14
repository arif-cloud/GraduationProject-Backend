package com.example.ArticleApi.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "popularArticles")
public class PopularArticle {
    private int rank;
    private String url;
    private String title;
    private String imageUrl;
    private String publishDate;
    private List<String> tags;
    private String description;
    private int reactions;

    public PopularArticle() {

    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReactions() {
        return reactions;
    }

    public void setReactions(int reactions) {
        this.reactions = reactions;
    }

    @Override
    public String toString() {
        return "PopularArticle{" +
                "rank=" + rank +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", tags=" + tags +
                ", description='" + description + '\'' +
                ", reactions=" + reactions +
                '}';
    }
}
