package com.cfs.bms.controller;

import com.cfs.bms.entity.Screen;
import com.cfs.bms.entity.Seat;
import com.cfs.bms.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatController {
    private  final SeatService seatService;
//add seats hw
@PostMapping
public ResponseEntity<Seat> addSeat(@RequestBody Seat seat){
    return ResponseEntity.ok(seatService.addSeat(seat));
}

    @GetMapping("/screen/{screenId}")
    public ResponseEntity<List<Seat>> getSeatByScreen(@PathVariable Long screenId){
        return ResponseEntity.ok(seatService.getSeatByScreen(screenId));
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long id){
        return ResponseEntity.ok(seatService.getSeatById(id));
    }

}
