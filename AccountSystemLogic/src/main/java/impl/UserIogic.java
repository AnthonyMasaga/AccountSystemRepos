package impl;

import org.example.domain.dto.MilesDto;
import org.example.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserIogic {

    List<UserDto> getAllUsers();
    UserDto getUser(String email);
    UserDto deleteMember(String email);
    UserDto addUser(UserDto userDto);
}
