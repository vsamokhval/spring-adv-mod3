package vss.spring.trans.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vss.spring.trans.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
