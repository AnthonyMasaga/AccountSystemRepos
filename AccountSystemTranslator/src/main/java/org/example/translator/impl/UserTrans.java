package org.example.translator.impl;

import org.example.domain.dto.UserDto;
import org.example.domain.persistence.User;

import java.util.List;

public interface UserTrans {


    List<UserDto> getAllUsers();
    UserDto getUser(String email);
    UserDto deleteMember(String email);
    UserDto addMember(UserDto userDto);




}
