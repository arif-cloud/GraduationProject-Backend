package com.example.ArticleApi.response;

public class ArticleStateResponse {
    private int id;
    private boolean saved;

    public ArticleStateResponse(int id, boolean saved) {
        this.id = id;
        this.saved = saved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }
}
