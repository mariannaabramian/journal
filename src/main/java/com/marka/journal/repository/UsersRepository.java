package com.marka.journal.repository;

import com.marka.journal.model.Document;
import com.marka.journal.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {
    User findByLogin(String username);


}
