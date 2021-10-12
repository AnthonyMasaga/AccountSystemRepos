package trans;

import org.example.domain.dto.UserDto;
import org.example.domain.persistence.User;
import org.example.repository.persistence.MilesRepo;
import org.example.repository.persistence.UserRepo;
import org.example.translator.impl.UserTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Component
public class UserTransImpl implements UserTrans {
    //private UserTrans userTrans;
    private UserRepo userRepo;
    private MilesRepo milesRepo;

    @Autowired
    public UserTransImpl(UserRepo userRepo, MilesRepo milesRepo) {
        this.userRepo = userRepo;
        this.milesRepo = milesRepo;
    }


    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> themembers = new ArrayList<>();
        try {
            for (User miles: userRepo.findAll()){
                themembers.add(new UserDto(miles));
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot get The members",e);
        }
        return themembers;
    }

    @Override
    public UserDto getUser(String email) {
        User user;
        try {
            user = userRepo.getUserByEmail(email);
        }catch (Exception e){
            throw new RuntimeException("Cannot get The member with that email",e);
        }
        return new UserDto(user);
    }

    @Override
    public UserDto deleteMember(String email) {
        User user;
        try {
            user = userRepo.getUserByEmail(email);
            userRepo.delete(user);
        }catch (Exception e){
            throw new RuntimeException("Cannot delete the member by email",e);
        }
        return new UserDto(user);
    }

    @Override
    public UserDto addMember(UserDto userDto) {
        User user;
        try {
            user = userDto.buildPerson(userDto);
            User save =userRepo.save(user);
            //milesRepo.save(save.getMiles());
        }catch (Exception e){
            throw new RuntimeException("Cannot add the member",e);
        }
        return new UserDto(user);
    }
}
