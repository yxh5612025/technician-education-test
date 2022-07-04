package com.zzhy.supervise.mapper;


import com.zzhy.supervise.domain.Slideshow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface ApiSlideshowMapper {
    @Insert("insert into slideshow ( title, sort, \n" +
            "      position_type, start_time, end_time, \n" +
            "      jump_url, img_url, update_time, \n" +
            "      del_flag, status,create_by)\n" +
            "    values ( #{title,jdbcType=VARCHAR}, #{sort,jdbcType=TINYINT}, \n" +
            "      #{positionType,jdbcType=VARCHAR}, #{startTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, \n" +
            "      #{jumpUrl,jdbcType=VARCHAR}, #{imgUrl,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, \n" +
            "      '1', #{status,jdbcType=CHAR},#{createBy}) ")
    int insertSlideshow(Slideshow slideshow);

    @Select("select * from slideshow where banner_id =#{id}")
    Slideshow findById(Long id);

    int updateSlideshow(Slideshow slideshow);

    @Update("update slideshow set  del_flag='2' delete_id = #{arg1},delete_name = #{arg2} where banner_id =#{arg0}")
    int deleteSlideshow(Long bannerId,Long userId,String userName);

    List<Slideshow> findSlideshowByTitleAndLocation(Map map);

    @Select("select * from slideshow where del_flag = '1' order by sort desc ")
    List<Slideshow> findSlideshow();
}
