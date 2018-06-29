package org.epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.epsi.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao{

	@PersistenceContext
	private EntityManager entityManager;

	public List<User> getUsers() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

		final CriteriaQuery<User> lCriteriaQuery = lCriteriaBuilder.createQuery(User.class);
		final Root<User> lRoot = lCriteriaQuery.from(User.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<User> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

		return lTypedQuery.getResultList();
	}

}
