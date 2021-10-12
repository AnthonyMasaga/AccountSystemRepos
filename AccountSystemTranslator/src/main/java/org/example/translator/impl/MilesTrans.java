package org.example.translator.impl;
import org.example.domain.dto.MilesDto;
import org.example.domain.dto.UserDto;
import org.example.domain.persistence.Miles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
@Repository
public interface MilesTrans {
    List<MilesDto> getAllMiles();
    MilesDto getMemberMiles(String email);
    MilesDto addMiles(UserDto milesDto);
    MilesDto deleteMiles(String email);
}

