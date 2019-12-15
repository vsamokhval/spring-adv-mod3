package vss.spring.trans.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vss.spring.trans.model.Phone;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Integer> {
}
