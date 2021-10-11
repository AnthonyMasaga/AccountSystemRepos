package trans;
import org.example.domain.dto.AccountTypeDto;
import org.example.domain.dto.GoalsDto;
import org.example.domain.persistence.AccountType;
import org.example.domain.persistence.Goals;
import org.example.repository.persistence.GoalsRepo;
import org.example.translator.impl.GoalsTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GoalsTranslmpl implements GoalsTrans {
    private final GoalsRepo goalsRepo;

    @Autowired
    public GoalsTranslmpl(GoalsRepo goalsRepo) {
        this.goalsRepo = goalsRepo;
    }

    @Override
    public List<GoalsDto> getGoals() {
        List<GoalsDto> goalsDto = new ArrayList<>();
        try {
            for(Goals goals: goalsRepo.findAll()){
                goalsDto.add(new GoalsDto(goals));
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot get customers from the db",e);
        }
        return goalsDto;

    }

    @Override
    public GoalsDto create(GoalsDto Goals) {
        return null;
    }

    @Override
    public GoalsDto save(GoalsDto Goals) {
        return null;
    }
    @Override
    public void someMethod() {
    }
    @Override
    public void delete(Goals goals) {

    }


 
}
