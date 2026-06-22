package com.cfs.bms.repository;

import com.cfs.bms.entity.Screen;
import com.cfs.bms.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen,Long> {


    List<Screen> findByTheaterId(Long theaterId);
}
