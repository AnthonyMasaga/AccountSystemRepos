package org.example.repository.persistence;

import org.example.domain.persistence.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionRepo extends JpaRepository<AccountTransaction, Long>  {


}
