package org.example.translator.impl;


import org.example.domain.dto.RewardsDto;
import org.example.domain.persistence.Rewards;

import java.util.List;

public interface RewardsTrans {
    List<RewardsDto> getAllRewards();
    RewardsDto updateReward(Long id,int price);
    RewardsDto deleteReward(Long id);
    RewardsDto addReward(RewardsDto rewardsDTO);
}
