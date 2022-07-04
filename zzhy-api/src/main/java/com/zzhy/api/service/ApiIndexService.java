package com.zzhy.api.service;

import com.zzhy.supervise.domain.Article;
import com.zzhy.supervise.domain.Slideshow;

import java.util.List;

public interface ApiIndexService {
    List<Slideshow> findSlideshow();



    List<Article> findArticle();


    Article queryArticleById(Long articleId);
}
