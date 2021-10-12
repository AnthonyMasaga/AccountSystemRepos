package org.example.repository.persistence;

import org.example.domain.persistence.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Transactional
    @Modifying
    @Query(value = "select * from persons where persons.email=:email",nativeQuery = true)
    User getUserByEmail(String email);
}
