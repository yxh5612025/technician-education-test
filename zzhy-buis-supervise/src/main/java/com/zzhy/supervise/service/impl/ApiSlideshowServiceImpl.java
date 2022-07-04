package com.zzhy.supervise.service.impl;

import com.zzhy.common.core.controller.BaseController;
import com.zzhy.supervise.domain.Slideshow;
import com.zzhy.supervise.mapper.ApiSlideshowMapper;

import com.zzhy.supervise.service.ApiSlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApiSlideshowServiceImpl implements ApiSlideshowService {

    @Autowired
    private ApiSlideshowMapper apiSlideshowMapper;

    @Override
    public int insertSlideshow(Slideshow slideshow) {
        slideshow.setUpdateTime(new Date());
        BaseController baseController = new BaseController();
        String username = baseController.getUsername();
        slideshow.setCreateBy(username);
        int count = apiSlideshowMapper.insertSlideshow(slideshow);
        return count;
    }

    @Override
    public Slideshow findById(Long id) {
        return apiSlideshowMapper.findById(id);
    }

    @Override
    public int updateSlideshow(Slideshow slideshow) {
        slideshow.setUpdateTime(new Date());
        BaseController baseController = new BaseController();
        String username = baseController.getUsername();
       slideshow.setCreateBy(username);
        int count = apiSlideshowMapper.updateSlideshow(slideshow);
        return count;
    }

    @Override
    public int deleteSlideshow(Long bannerId) {
        BaseController baseController = new BaseController();
        Long userId = baseController.getUserId();
        String username = baseController.getUsername();
        int count = apiSlideshowMapper.deleteSlideshow(bannerId,userId,username);
        return count;
    }

    @Override
    public List<Slideshow> findSlideshowByTitleAndLocation(HashMap map) {
        map.put("delFlag","1");
        List<Slideshow> slideshowList =apiSlideshowMapper.findSlideshowByTitleAndLocation(map);
        return slideshowList;
    }

    @Override
    public List<Slideshow> findSlideshow() {
        List<Slideshow> slideshowList = apiSlideshowMapper.findSlideshow();
        return slideshowList;
    }
}
