package com.zzhy.supervise.service;



import com.zzhy.supervise.domain.Article;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface ApiArticleService {

    Article findById(Long id);

    List<Article> findArticle();

    int insertArticlew(Article article);

    int updateArticle(Article article);

    int deleteArticle( Long articleId);

    List<Article> findArticleByTypeAndNameAndTerminal(Map map);
}
