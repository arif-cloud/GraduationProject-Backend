package com.example.ArticleApi.controller;

import com.example.ArticleApi.model.Article;
import com.example.ArticleApi.model.Category;
import com.example.ArticleApi.model.PopularArticle;
import com.example.ArticleApi.model.SavedArticle;
import com.example.ArticleApi.repository.ArticleRepository;
import com.example.ArticleApi.repository.CategoryRepository;
import com.example.ArticleApi.repository.PopularArticleRepository;
import com.example.ArticleApi.repository.SavedArticleRepository;
import com.example.ArticleApi.response.ArticleStateResponse;
import com.example.ArticleApi.response.PostRequestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    PopularArticleRepository popularArticleRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    SavedArticleRepository savedArticleRepository;

    @Operation(summary = "Get list of all articles")
    @GetMapping("/articles/all")
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Operation(summary = "Get articles from the category received as parameter in paginated format")
    @GetMapping("/articles/{category}")
    public List<Article> getArticlesByCategory(
            @Parameter(description = "category of articles to be received") @PathVariable String category,
            @Parameter(description = "page of the list of articles to be received") @RequestParam int page
    ) {
        Pageable pageable = PageRequest.of(page, 20, Sort.by("title"));
        return articleRepository.findByTagsIn(category, pageable);
    }

    @Operation(summary = "Get categories")
    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Operation(summary = "Get a article by its title")
    @GetMapping("/articles/search")
    public List<Article> getArticlesBySearch(
            @Parameter(description = "title of article to be searched") @RequestParam String q
    ) {
        return articleRepository.findByTitleContainingIgnoreCase(q);
    }

    @Operation(summary = "Get popular articles")
    @GetMapping("/articles/popular")
    public List<PopularArticle> getPopularArticles() {
        return popularArticleRepository.findAll();
    }

    @Operation(summary = "Save the article")
    @PostMapping("/article/save")
    public ResponseEntity<PostRequestResponse> saveArticle(
            @Parameter(description = "article to save") @RequestBody Article article,
            @Parameter(description = "user's id") @RequestParam String userId
    ) {
        try {
            savedArticleRepository.insert(new SavedArticle(userId, article));
            return ResponseEntity.status(HttpStatus.OK).body(new PostRequestResponse(201, "Saved Successfully !"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PostRequestResponse(404, e.getLocalizedMessage()));
        }
    }

    @Operation(summary = "Removed article from saved articles list")
    @PostMapping("/article/{article_id}/remove")
    public ResponseEntity<PostRequestResponse> removeArticle(
            @Parameter(description = "article to remove") @PathVariable int article_id,
            @Parameter(description = "user's id") @RequestParam String userId
    ) {
        try {
            SavedArticle savedArticle = savedArticleRepository.findByUserIdAndArticleId(userId, article_id);
            savedArticleRepository.delete(savedArticle);
            return ResponseEntity.status(HttpStatus.OK).body(new PostRequestResponse(201, "Removed Successfully !"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PostRequestResponse(404, e.getLocalizedMessage()));
        }
    }

    @Operation(summary = "Get list of saved articles")
    @GetMapping("articles/saved")
    public List<Article> getSavedArticles(
            @Parameter(description = "user's id") @RequestParam String userId
    ) {
        return savedArticleRepository.findByUserId(userId).stream().map(SavedArticle::getArticle).collect(Collectors.toList());
    }

    @Operation(summary = "Get state of article")
    @GetMapping("article/{article_id}/state")
    public ArticleStateResponse getArticleState(
            @Parameter(description = "id of the article whose status will be received") @PathVariable int article_id,
            @Parameter(description = "user's id") @RequestParam String userId
    ) {
        boolean saved = savedArticleRepository.existsByUserIdAndArticleId(userId, article_id);
        return new ArticleStateResponse(article_id, saved);
    }

}
