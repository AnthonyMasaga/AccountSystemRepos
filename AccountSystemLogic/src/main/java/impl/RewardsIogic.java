package impl;

import org.example.domain.dto.RewardsDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RewardsIogic {
    List<RewardsDto> getAllRewards();

    RewardsDto addReward(RewardsDto rewardsDto);

    RewardsDto updateRewards(Long id, int price);

    RewardsDto deleteRewards(Long id);
}

