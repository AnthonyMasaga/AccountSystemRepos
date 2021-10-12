package impl;

import org.example.domain.dto.MilesDto;
import org.example.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MilesIogic {
    List<MilesDto> getAllMiles();
    MilesDto getMemberMiles(String email);
    MilesDto addMiles(UserDto milesDtos);
    MilesDto deleteMiles(String email);


}
