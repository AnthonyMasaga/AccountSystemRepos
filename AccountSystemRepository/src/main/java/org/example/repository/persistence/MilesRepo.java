package org.example.repository.persistence;


import org.example.domain.persistence.Miles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MilesRepo extends JpaRepository<Miles,Long> {
}
