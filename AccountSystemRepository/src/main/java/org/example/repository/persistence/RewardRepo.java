package org.example.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.domain.persistence.Rewards;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepo extends JpaRepository<Rewards, Long> {
}
