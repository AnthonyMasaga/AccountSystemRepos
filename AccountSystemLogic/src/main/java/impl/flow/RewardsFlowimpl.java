package impl.flow;


import impl.RewardsIogic;
import org.example.domain.dto.RewardsDto;
import org.example.translator.impl.RewardsTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class RewardsFlowimpl implements RewardsIogic {
    private RewardsTrans rewardsTrans;

    @Autowired
    public RewardsFlowimpl( RewardsTrans rewardsTrans) {
        this.rewardsTrans = rewardsTrans;
    }


    @Override
    public List<RewardsDto> getAllRewards() {
        return rewardsTrans.getRewards();
    }

    @Override
    public RewardsDto addReward(RewardsDto rewardsDto) {
        return null;
    }

    @Override
    public RewardsDto updateRewards(Long id, int price) {
        return null;
    }

    @Override
    public RewardsDto deleteRewards(Long id) {
        return null;
    }
}

