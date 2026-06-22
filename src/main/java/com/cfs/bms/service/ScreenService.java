package com.cfs.bms.service;

import com.cfs.bms.entity.Movie;
import com.cfs.bms.entity.Screen;
import com.cfs.bms.entity.Theater;
import com.cfs.bms.repository.ScreenRepository;
import com.cfs.bms.repository.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreenService {
    private final ScreenRepository screenRepository;
    private final TheaterService theaterService;
    private final TheaterRepository theaterRepository;

    //addscreen hw
   public Screen addScreen(Screen screen){
       Theater theater=theaterRepository.findById(screen.getTheater().getId())
               .orElseThrow(()->new RuntimeException("theater not found"));
       screen.setTheater(theater);
       return screenRepository.save(screen);
    }
    public List<Screen> getAllScreen(){
        return screenRepository.findAll();
    }
    public Screen getScreenById(Long id){
        return screenRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Screen not found with id:"+id));
    }
    public List<Screen> getScreenByTheater(Long theaterId){
        return screenRepository.findByTheaterId(theaterId);
    }
}
