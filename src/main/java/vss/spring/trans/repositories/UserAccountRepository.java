package vss.spring.trans.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vss.spring.trans.model.UserAccount;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Integer> {
}
