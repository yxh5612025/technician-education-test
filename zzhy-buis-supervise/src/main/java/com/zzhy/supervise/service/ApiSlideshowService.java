package com.zzhy.supervise.service;



import com.zzhy.supervise.domain.Slideshow;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ApiSlideshowService {
    int insertSlideshow(Slideshow slideshow);

    Slideshow findById(Long id);

    int updateSlideshow(Slideshow slideshow);

    int deleteSlideshow( Long bannerId);

    List<Slideshow> findSlideshowByTitleAndLocation(HashMap map);

    List<Slideshow> findSlideshow();
}
