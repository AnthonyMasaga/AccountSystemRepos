package impl;

import org.example.domain.dto.MilesDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MilesIogic {
    List<MilesDto> getAllMiles();

    MilesDto getMemberMiles(String name);
}
