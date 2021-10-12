package impl.flow;

import impl.MilesIogic;
import org.example.domain.dto.MilesDto;
import org.example.domain.dto.UserDto;
import org.example.translator.impl.MilesTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class MilesFlowimpl implements MilesIogic {
    private MilesTrans milesTrans;

    @Autowired
    public MilesFlowimpl(MilesTrans milesTrans) {
        this.milesTrans = milesTrans;
    }


    @Override
    public List<MilesDto> getAllMiles() {
        return milesTrans.getAllMiles();
    }

    @Override
    public MilesDto getMemberMiles(String email) {
        return milesTrans.getMemberMiles(email);
    }

    @Override
    public MilesDto addMiles(UserDto milesDtos) {
        return milesTrans.addMiles(milesDtos);
    }

    @Override
    public MilesDto deleteMiles(String email) {
        return milesTrans.deleteMiles(email);
    }
}



