package com.zzhy.supervise.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import com.zzhy.supervise.domain.Slideshow;
import com.zzhy.supervise.domain.vo.SlideshowVo;
import com.zzhy.supervise.service.ApiSlideshowService;
import com.zzhy.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/supervise/banner")
public class ApiSlideshowController {



    @Autowired
    private ApiSlideshowService apiSlideshowService;

//    @GetMapping("/list")
//    public AjaxResult list(int pageNum,int pageSize){
//        PageHelper.startPage(pageNum,pageSize);
//        List<Slideshow> slideshowList = apiSlideshowService.findSlideshow();
//
//        PageInfo<Slideshow> slideshowPageInfo = new PageInfo<>(slideshowList);
//        SlideshowVo slideshowVo = new SlideshowVo();
//        slideshowVo.setBannerList(slideshowPageInfo.getList());
//        slideshowVo.setTotal(slideshowPageInfo.getTotal());
//        return AjaxResult.success(slideshowVo);
//    }

    @PostMapping("/add")
    public AjaxResult insert(@RequestBody Slideshow slideshow){
        int count = apiSlideshowService.insertSlideshow(slideshow);
        return count>0?AjaxResult.success():AjaxResult.error();
    }

    @GetMapping("/getInfo/{bannerId}")
    public AjaxResult findById(@PathVariable Long bannerId){
        Slideshow slideshow = apiSlideshowService.findById(bannerId);

        return AjaxResult.success(slideshow);
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Slideshow slideshow){
        int count = apiSlideshowService.updateSlideshow(slideshow);
        return count>0?AjaxResult.success():AjaxResult.error();
    }
    @DeleteMapping("/tombstone/{bannerId}")
    public AjaxResult delete(@PathVariable Long bannerId){
        int count = apiSlideshowService.deleteSlideshow(bannerId);
        return count>0?AjaxResult.success():AjaxResult.error();
    }

    @GetMapping("/list")
    public AjaxResult query(@RequestParam HashMap map,  int pageNum, int  pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Slideshow> slideshowList = apiSlideshowService.findSlideshowByTitleAndLocation(map);
        PageInfo<Slideshow> slideshowPageInfo = new PageInfo<>(slideshowList);
        SlideshowVo slideshowVo = new SlideshowVo();
        slideshowVo.setBannerList(slideshowPageInfo.getList());
        slideshowVo.setTotal(slideshowPageInfo.getTotal());
        return AjaxResult.success(slideshowVo);
    }
}
