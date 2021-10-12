package org.example.repository.persistence;

import org.example.domain.dto.AccountTypeDto;
import org.example.domain.persistence.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AccountTransactionRepo extends JpaRepository<AccountTransaction, Long>  {
    @Transactional
    @Modifying
    @Query(value = "delete from Person_Transactions join persons on Person_Transactions.person_id=person.person_id where persons.email=:email",nativeQuery = true)
    void deleteUserTransactions(String email);

    @Transactional
    @Modifying
    @Query(value = "select * from Person_Transactions join persons on Person_Transactions.person_id=person.person_id where persons.email=:email",nativeQuery = true)
    List<AccountTransaction> getUserTransactions(String email);

    AccountTypeDto getTypeAccount();
}
