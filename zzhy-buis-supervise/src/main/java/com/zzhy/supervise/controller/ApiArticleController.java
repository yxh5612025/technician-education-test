package com.zzhy.supervise.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import com.zzhy.supervise.domain.Article;

import com.zzhy.supervise.domain.vo.ArticleVo;
import com.zzhy.supervise.service.ApiArticleService;
import com.zzhy.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/supervise/article")
public class ApiArticleController {

    @Autowired
    private ApiArticleService apiArticleService;



    @PostMapping("/add")
    public AjaxResult insert(@RequestBody Article article){
        int count = apiArticleService.insertArticlew(article);
        return count>0?AjaxResult.success():AjaxResult.error();
    }

    @GetMapping("/getInfo/{articleId}")
    public AjaxResult findById( @PathVariable Long articleId){
        Article article = apiArticleService.findById(articleId);

        return AjaxResult.success(article);
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Article article){
        int count = apiArticleService.updateArticle(article);
        return count>0?AjaxResult.success():AjaxResult.error();
    }
    @DeleteMapping("/tombstone/{articleId}")
    public AjaxResult delete(@PathVariable Long articleId){
        int count = apiArticleService.deleteArticle(articleId);
        return count>0?AjaxResult.success():AjaxResult.error();
    }

    @GetMapping("/list")
    public AjaxResult query(@RequestParam Map map, int pageNum, int  pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articleList = apiArticleService.findArticleByTypeAndNameAndTerminal(map);
        PageInfo<Article> articlePageInfo = new PageInfo<>(articleList);
        ArticleVo articleVo = new ArticleVo();
        articleVo.setArticleList(articlePageInfo.getList());
        articleVo.setTotal(articlePageInfo.getTotal());
        return AjaxResult.success(articleVo);
    }
}
