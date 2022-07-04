package com.zzhy.supervise.domain.vo;

import com.zzhy.supervise.domain.Article;
import lombok.Data;


import java.util.List;
@Data
public class ArticleVo {
    private List<Article> articleList;

    private Long total;
}
