package com.zzhy.api.mapper;

import com.zzhy.supervise.domain.Article;
import com.zzhy.supervise.domain.Slideshow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface ApiIndexMapper {
    @Select("select * from slideshow where del_flag = '1' and end_time >= #{date} and status ='1' order by sort desc ")
    List<Slideshow> findSlideshow(Date date);

    List<Article> findArticle(Date date);

    @Select("select * from article where article_id = #{articleId}")
    Article queryArticleById(Long articleId);
}
