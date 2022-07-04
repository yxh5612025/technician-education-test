package com.zzhy.supervise.domain.vo;

import com.zzhy.supervise.domain.Slideshow;
import lombok.Data;

import java.util.List;

@Data
public class SlideshowVo {

    private List<Slideshow> bannerList;

    private Long total;
}
