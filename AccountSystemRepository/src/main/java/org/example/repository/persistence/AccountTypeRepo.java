package org.example.repository.persistence;

import org.example.domain.persistence.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AccountTypeRepo  extends JpaRepository<AccountType,Long> {
    @Transactional
    @Modifying
    @Query(value = "select * from account_types where nmonic=:nmonic",nativeQuery = true)
    AccountType getAccountType(@Param("nmonic") String nmonic);


    @Transactional
    @Modifying
    @Query(value = "delete from account_types where nmonic=:nmonic",nativeQuery = true)
    void deleteByNmonic(@Param("nmonic") String nmonic);

}
