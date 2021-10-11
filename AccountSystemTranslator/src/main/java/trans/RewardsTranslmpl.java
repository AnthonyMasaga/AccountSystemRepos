package trans;

import org.example.domain.dto.RewardsDto;
import org.example.domain.persistence.Rewards;
import org.example.repository.persistence.RewardRepo;
import org.example.translator.impl.RewardsTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RewardsTranslmpl implements RewardsTrans {
    private final RewardRepo rewardsRepo;

    @Autowired
    public RewardsTranslmpl(RewardRepo rewardsRepo){
        this.rewardsRepo = rewardsRepo;
    }

    @Override
    public List<RewardsDto> getRewards() {
        List<RewardsDto> rewardsDtos = new ArrayList<>();
        try {
            for (Rewards rewards:rewardsRepo.findAll()) {
                rewardsDtos.add(new RewardsDto(rewards));
            }
        } catch (Exception e) {
            throw new RuntimeException("Cannot get customers from the db", e);
        }
        return rewardsDtos;

    }

    @Override
    public RewardsDto create(RewardsDto Rewards) {
        return null;
    }

    @Override
    public RewardsDto save(RewardsDto Rewards) {
        return null;
    }

    @Override
    public void someMethod() {

    }

    @Override
    public void delete(Rewards rewards) {

    }
}
