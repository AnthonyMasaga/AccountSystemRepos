package impl;

import org.example.domain.dto.MilesDto;
import org.example.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserIogic {

    List<UserDto> getAllCustomer();

    MilesDto getUserEmail(String email);
}
