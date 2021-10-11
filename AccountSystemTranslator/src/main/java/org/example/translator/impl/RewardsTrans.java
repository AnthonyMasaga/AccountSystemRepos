package org.example.translator.impl;


import org.example.domain.dto.MilesDto;
import org.example.domain.dto.RewardsDto;
import org.example.domain.persistence.Goals;
import org.example.domain.persistence.Miles;
import org.example.domain.persistence.Rewards;

import java.util.List;

public interface RewardsTrans {
    List<RewardsDto> getRewards();
    RewardsDto create(RewardsDto Rewards);
    RewardsDto  save(RewardsDto Rewards);

    void someMethod();

    void delete(Rewards rewards);
}
