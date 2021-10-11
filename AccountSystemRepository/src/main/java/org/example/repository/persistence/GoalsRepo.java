package org.example.repository.persistence;


import org.example.domain.persistence.Goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalsRepo extends JpaRepository<Goals, Long>{

}
