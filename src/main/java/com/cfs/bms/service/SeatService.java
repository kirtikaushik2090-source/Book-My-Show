package com.cfs.bms.service;

import com.cfs.bms.entity.Movie;
import com.cfs.bms.entity.Screen;
import com.cfs.bms.entity.Seat;
import com.cfs.bms.repository.ScreenRepository;
import com.cfs.bms.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;
    private final ScreenRepository screenRepository;
    //addseat hw
    public Seat addSeat(Seat seat){
        Screen screen=screenRepository.findById(seat.getScreen().getId())
                .orElseThrow(()->new RuntimeException("Screen not found"));
        seat.setScreen(screen);
        return seatRepository.save(seat);
    }

    public List<Seat>getSeatByScreen(Long screenId){
        return seatRepository.findByScreenId(screenId);
    }
    public Seat getSeatById(Long id){
        return seatRepository.findById(id)
                .orElseThrow(()->new RuntimeException("seat not found with id:"+id));
    }
}
