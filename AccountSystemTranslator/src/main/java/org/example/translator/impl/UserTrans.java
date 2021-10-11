package org.example.translator.impl;

import org.example.domain.dto.RewardsDto;
import org.example.domain.dto.UserDto;
import org.example.domain.persistence.Rewards;
import org.example.domain.persistence.User;

import java.util.List;

public interface UserTrans {
    List<UserDto> getCustomers();
    UserDto create(UserDto User);
    UserDto  save(UserDto User);

    void someMethod();

    void delete(User user);
}
