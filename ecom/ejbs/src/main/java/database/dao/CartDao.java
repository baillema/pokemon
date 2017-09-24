package database.dao;

import database.entities.CartsEntity;
import database.services.GenericDaoJpaImpl;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CartDao extends GenericDaoJpaImpl<CartsEntity> {

    public List findAllByBoughtCart(int userId) {
        return em.createQuery("FROM CartsEntity C WHERE C.state ='Bought' AND C.userId = :userId")
                .setParameter("userId", userId)
                .getResultList();
    }

    public CartsEntity findCurrentCart(int userId) {
        return (CartsEntity) em.createQuery("FROM CartsEntity C WHERE C.state= 'Current' AND C.userId = :userId")
                .setParameter("userId", userId)
                .getSingleResult();
    }
}
