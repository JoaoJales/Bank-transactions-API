package bank.api.domain.transaction;

import bank.api.domain.account.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("""
    SELECT t FROM Transaction t
    WHERE t.originAccount = :account OR t.destinyAccount = :account
    ORDER BY t.date DESC
""")
    Page<Transaction> findAllByAccount(@Param("account") Account account, Pageable pageable);
}
