package com.zzhy.supervise.mapper;


import com.zzhy.supervise.domain.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface ApiArticleMapper {
    @Select("select * from article where del_flag = '1' order  by article_top asc , start_time desc ")
    List<Article> findArticle();


    @Insert("insert into article ( article_title, article_type, \n" +
            "      article_top, terminal_type, start_time, \n" +
            "      end_time, article_details, del_flag, \n" +
            "      status,update_time,sort,remark,create_by)\n" +
            "    values ( #{articleTitle,jdbcType=VARCHAR}, #{articleType,jdbcType=VARCHAR}, \n" +
            "      #{articleTop,jdbcType=CHAR}, #{terminalType,jdbcType=VARCHAR}, #{startTime,jdbcType=TIMESTAMP}, \n" +
            "      #{endTime,jdbcType=TIMESTAMP}, #{articleDetails,jdbcType=VARCHAR}, '1', \n" +
            "      #{status,jdbcType=CHAR} , #{updateTime},#{sort},#{remark},#{createBy})")
    int insertArticle(Article article);
    
    @Select("select * from article where article_id =#{id} and del_flag = '1'")
    Article findById(Long id);


    int updateArticle(Article article);

    @Update("update article set  del_flag='2',delete_name = #{arg2},delete_id = #{arg1} where article_id =#{arg0}")
    int deleteArticle( Long articleId,Long userId,String username);

    List<Article> findArticleByTypeAndNameAndTerminal(Map map);
}
