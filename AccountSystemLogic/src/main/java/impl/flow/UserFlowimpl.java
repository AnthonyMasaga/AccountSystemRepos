package impl.flow;

import impl.UserIogic;
import org.example.domain.dto.MilesDto;
import org.example.domain.dto.UserDto;
import org.example.translator.impl.UserTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Component
public class UserFlowimpl implements UserIogic {
    private UserTrans userTrans;

    @Autowired
    public UserFlowimpl(UserTrans userTrans) {
        this. userTrans=  userTrans;
    }
    @Override
    public List<UserDto> getAllUsers()
    {
        return userTrans.getAllUsers();
    }

    @Override
    public UserDto getUser(String email) {
        return userTrans.getUser(email);
    }

    @Override
    public UserDto deleteMember(String email) {
        return userTrans.deleteMember(email);
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        return userTrans.addMember(userDto);
    }
}