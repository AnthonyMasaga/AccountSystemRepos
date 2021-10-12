package trans;

import org.example.domain.dto.RewardsDto;
import org.example.domain.persistence.Rewards;
import org.example.repository.persistence.RewardRepo;
import org.example.translator.impl.RewardsTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Component
public class RewardsTranslmpl implements RewardsTrans {
    private final RewardRepo rewardsRepo;

    @Autowired
    public RewardsTranslmpl(RewardRepo rewardsRepo) {
        this.rewardsRepo = rewardsRepo;
    }


    @Override
    public List<RewardsDto> getAllRewards() {
        List<RewardsDto> therewards = new ArrayList<>();
        try {
            for (Rewards rewards: rewardsRepo.findAll()){
                therewards.add(new RewardsDto(rewards));
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot get The rewards",e);
        }
        return therewards;
    }

    @Override
    public RewardsDto updateReward(Long id, int price) {
        Rewards rewards;
        try {
            rewardsRepo.updateReward(id,price);
            rewards = rewardsRepo.getOne(id);
        }catch (Exception e){
            throw new RuntimeException("Cannot update the reward",e);
        }
        return new RewardsDto(rewards);
    }

    @Override
    public RewardsDto deleteReward(Long id) {
        Rewards rewards;
        try {
            rewards = rewardsRepo.getOne(id);
            rewardsRepo.delete(rewards);
        }catch (Exception e){
            throw new RuntimeException("Cannot delete the reward",e);
        }
        return new RewardsDto(rewards);
    }

    @Override
    public RewardsDto addReward(RewardsDto rewardsDTO) {
        Rewards rewards;
        try {
            rewards = rewardsDTO.buildRewards(rewardsDTO);
            rewardsRepo.save(rewards);
        }catch (Exception e){
            throw new RuntimeException("Cannot add the reward",e);
        }
        return new RewardsDto(rewards);
    }
}
