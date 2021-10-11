package trans;

import org.example.domain.dto.UserDto;
import org.example.domain.persistence.User;
import org.example.repository.persistence.UserRepo;
import org.example.translator.impl.UserTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserTransImpl implements UserTrans {
    private final UserRepo customerRepo;

    @Autowired
    public UserTransImpl(UserRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<UserDto> getCustomers() {
        List<UserDto> customerDtos = new ArrayList<>();
        try {
            for(User customer:customerRepo.findAll()){
                customerDtos.add(new UserDto(customer));
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot get customers from the db",e);
        }
        return customerDtos;

    }

    @Override
    public UserDto create(UserDto User) {
        return null;
    }

    @Override
    public UserDto save(UserDto User) {
        return null;
    }

    @Override
    public void someMethod() {

    }

    @Override
    public void delete(User user) {

    }
}
