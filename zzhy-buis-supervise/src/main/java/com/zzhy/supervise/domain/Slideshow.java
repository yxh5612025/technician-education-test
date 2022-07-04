package com.zzhy.supervise.domain;



import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


import java.util.Date;
@Data
public class Slideshow {

    private Long bannerId;

    private String title;

    private Byte sort;

    /**
     * 轮播图位置
     */
    private String positionType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 对外发布截止时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 轮播图跳转地址
     */
    private String jumpUrl;

    /**
     * 图片上传
     */
    private String imgUrl;

    /**
     * 最后创建/修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


    private String delFlag;

    private String status;

    private String deleteName;

    private Long deleteId;

    private String createBy;
}
