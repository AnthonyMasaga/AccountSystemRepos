package impl.flow;

import impl.GoalsIogic;
import org.example.domain.dto.GoalsDto;
import org.example.translator.impl.GoalsTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoalsFlowimpl implements GoalsIogic {
    private GoalsTrans goalsTrans;

    @Autowired
    public GoalsFlowimpl(GoalsTrans goalsTrans) {
        this.goalsTrans= goalsTrans;
    }


    @Override
    public List<GoalsDto> getAllGoals() {
        return goalsTrans.getGoals();
    }


    }

