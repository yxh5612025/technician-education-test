package com.zzhy.supervise.service.impl;

import com.zzhy.common.core.controller.BaseController;
import com.zzhy.supervise.domain.Article;
import com.zzhy.supervise.domain.Slideshow;
import com.zzhy.supervise.mapper.ApiArticleMapper;
import com.zzhy.supervise.mapper.ApiSlideshowMapper;
import com.zzhy.supervise.service.ApiArticleService;
import com.zzhy.supervise.service.ApiSlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ApiArticleServiceImpl implements ApiArticleService {

    @Autowired
    private ApiArticleMapper apiArticleMapper;


    @Override
    public Article findById(Long id) {
        return apiArticleMapper.findById(id);
    }


    @Override
    public List<Article> findArticle() {
        return apiArticleMapper.findArticle();
    }

    @Override
    public int insertArticlew(Article article) {
        article.setUpdateTime(new Date());
//        article.setUrl();
        BaseController baseController = new BaseController();
        String username = baseController.getUsername();
        article.setCreateBy(username);
        int count = apiArticleMapper.insertArticle(article);
        return count;
    }

    @Override
    public int updateArticle(Article article) {
        article.setUpdateTime(new Date());
        BaseController baseController = new BaseController();
        String username = baseController.getUsername();
        article.setCreateBy(username);
        int count = apiArticleMapper.updateArticle(article);
        return count;
    }

    @Override
    public int deleteArticle( Long articleId) {
        BaseController baseController = new BaseController();
        Long userId = baseController.getUserId();
        String username = baseController.getUsername();
        int count = apiArticleMapper.deleteArticle(articleId,userId,username);
        return count;
    }

    @Override
    public List<Article> findArticleByTypeAndNameAndTerminal(Map map) {
        map.put("delFlag","1");
        List<Article> articleList =apiArticleMapper.findArticleByTypeAndNameAndTerminal(map);
        return articleList;
    }
}
