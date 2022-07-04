package com.zzhy.api.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzhy.api.service.ApiIndexService;
import com.zzhy.common.core.domain.AjaxResult;
import com.zzhy.supervise.domain.Article;
import com.zzhy.supervise.domain.Slideshow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/index")
public class ApiIndexController {

    @Autowired
    private ApiIndexService apiIndexService;

    @GetMapping("/slideshow")
    public AjaxResult slideshow(){
        List<Slideshow> slideshowList = apiIndexService.findSlideshow();

        return AjaxResult.success(slideshowList);
    }

    @GetMapping("/article")
    public AjaxResult article(){
        List<Article> articleList = apiIndexService.findArticle();

        return AjaxResult.success(articleList);
    }
    @GetMapping("/articles")
    public AjaxResult moreArticle(int limit,int size){
        PageHelper.startPage(limit, size);
        List<Article> articleList = apiIndexService.findArticle();
        PageInfo<Article> articlePageInfo = new PageInfo<>(articleList);
        return AjaxResult.success(articlePageInfo);
    }

    @GetMapping("/getInfo/{articleId}")
    public AjaxResult getInfo(@PathVariable Long articleId){
        Article article = apiIndexService.queryArticleById(articleId);
        return AjaxResult.success(article);
    }
}
