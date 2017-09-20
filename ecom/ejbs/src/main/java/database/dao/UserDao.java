package database.dao;

import database.entities.UsersEntity;
import database.services.GenericDaoJpaImpl;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserDao extends GenericDaoJpaImpl<UsersEntity> {

    public UserDao() {
        super(UsersEntity.class);
    }

    public int createAccount(UsersEntity us){
        em.persist(us);
        em.flush();
        return us.getId();
    }

    public List findAll() {
        return em.createQuery("FROM UsersEntity U GROUP BY U.id").getResultList();
    }

    public UsersEntity findByEmailAndPassword(String email, String password) {
        return (UsersEntity) em.createQuery("SELECT U FROM UsersEntity U WHERE U.email = :email and U.password = :password")
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
    }

    public UsersEntity findAccountByHandle(String handle) {
        return (UsersEntity) em.createQuery(
                "SELECT U FROM UsersEntity U WHERE U.handle = :handle")
                .setParameter("handle", handle)
                .getSingleResult();
    }
}


