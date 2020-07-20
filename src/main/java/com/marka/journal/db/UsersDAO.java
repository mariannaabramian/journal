package com.marka.journal.db;

import com.marka.journal.model.*;
import com.sun.istack.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Repository
public class UsersDAO {
    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public Role createRole(String name) {
        Role role = new Role(name);
        manager.persist(role);
        return role;
    }

    public List<Role> findAllRoles() {
        return manager.createQuery("SELECT r from Role r", Role.class).getResultList();
    }

    @Nullable
    public Role findRoleByName(String name) {
        try {
            return manager.createQuery("SELECT r from Role r WHERE r.name = :nameToSearch", Role.class)
                    .setParameter("nameToSearch", name)
                    .getSingleResult();
        } catch (NoResultException cause) {
            return null;
        }
    }

    @Transactional
    public User createUser(String login, String encodedPassword, List<Role> roles) {
        User user = new User();
        user.setLogin(login);
        user.setRoles(roles);
        user.setEncodedPassword(encodedPassword);

        manager.persist(user);

        return user;
    }

    @Nullable
    public User findUserByLogin(String login) {
        try {
            return manager.createQuery("SELECT u from User u WHERE u.login = :login", User.class)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException cause) {
            return null;
        }
    }

    @Transactional
    public void banUser(User user) {
        user.setUserStatus(Status.BANNED);
    }

    @Transactional
    public void banUserBefore(Date registeredBefore) {
        manager.createQuery("UPDATE User set status = :status " +
                "where registrationDate < :before")
                .setParameter("status", Status.BANNED)
                .setParameter("before", registeredBefore)
                .executeUpdate();
    }
}
