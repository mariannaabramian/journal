package com.marka.journal.repository;

import com.marka.journal.model.Document;
import com.marka.journal.model.Status;
import com.marka.journal.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {
    User findByLogin(@Param("loginName") String login);

    Page<User> findByStatusOrderByLogin(Status status, Pageable page);

    Page<User> findByBonusScoreGreaterThan(int bonusScore, Pageable page);

    @Query("select u from User u where u.bonusScore > :bonusScore")
    List<User> findUsersScoreTooBig(@Param("bonusScore") int bonusScore);


}
