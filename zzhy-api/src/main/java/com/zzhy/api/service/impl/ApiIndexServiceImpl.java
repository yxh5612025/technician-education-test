package com.zzhy.api.service.impl;

import com.zzhy.api.mapper.ApiIndexMapper;
import com.zzhy.api.service.ApiIndexService;

import com.zzhy.supervise.domain.Article;
import com.zzhy.supervise.domain.Slideshow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApiIndexServiceImpl implements ApiIndexService {

    @Autowired
    private ApiIndexMapper apiIndexMapper;

    @Override
    public List<Slideshow> findSlideshow() {
        List<Slideshow> slideshowList = apiIndexMapper.findSlideshow(new Date());
        return slideshowList;
    }

    @Override
    public List<Article> findArticle() {
        List<Article> articleList = apiIndexMapper.findArticle(new Date());
        return articleList;
    }

    @Override
    public Article queryArticleById(Long articleId) {
        return apiIndexMapper.queryArticleById(articleId);
    }


}
