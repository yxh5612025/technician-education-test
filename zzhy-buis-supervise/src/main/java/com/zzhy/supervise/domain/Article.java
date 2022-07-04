package com.zzhy.supervise.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private Long articleId;

    private String articleTitle;

    private String articleType;

    private Byte sort;

    private String createBy;

    private String articleTop;

    private String terminalType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private String remark;

    private String articleDetails;

    private String delFlag;

    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String deleteName;

    private String url;

}