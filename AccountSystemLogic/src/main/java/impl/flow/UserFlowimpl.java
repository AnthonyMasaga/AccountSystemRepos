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
    private UserTrans customerTrans;

    @Autowired
    public UserFlowimpl(UserTrans customerTrans) {
        this.customerTrans = customerTrans;
    }



    @Override
    public List<UserDto> getAllCustomer() {
        List<UserDto> customerDtos = new ArrayList<>();
        //customerDtos.add(new UserDto());
        customerDtos.add(new UserDto());

        return customerTrans.getCustomers();
    }

    @Override
    public MilesDto getUserEmail(String email) {
        return null;
    }
}