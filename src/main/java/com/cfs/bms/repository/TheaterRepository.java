package com.cfs.bms.repository;

import com.cfs.bms.entity.Theater;
import com.cfs.bms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TheaterRepository extends JpaRepository<Theater,Long> {


    List<Theater> findByCityId(Long cityId);

    //List<Theater> findByCityId(Long cityId);
}
