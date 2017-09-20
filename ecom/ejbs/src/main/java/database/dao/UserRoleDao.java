package database.dao;

import database.entities.UsersRolesEntity;
import database.services.GenericDaoJpaImpl;

import javax.ejb.Stateless;

@Stateless
public class UserRoleDao extends GenericDaoJpaImpl<UsersRolesEntity>{
}
