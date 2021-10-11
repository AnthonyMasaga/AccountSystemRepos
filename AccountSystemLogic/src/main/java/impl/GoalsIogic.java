package impl;


import org.example.domain.dto.GoalsDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GoalsIogic {
    List<GoalsDto> getAllGoals();
}
