package ua.kvelinskyi.dao.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ua.kvelinskyi.dao.interfaces.Dao;
import ua.kvelinskyi.entity.User;
import ua.kvelinskyi.entity.User_;

import java.util.List;

@Component
public class UserDao  {

    @PersistenceContext
    private EntityManager entityManager;

    public User isExistUser(String login, String pass) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery =criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        Predicate predicate1 = criteriaBuilder.equal(root.get(User_.login), login);
        Predicate predicate2 = criteriaBuilder.equal(root.get(User_.password), pass);
        Predicate predicate = criteriaBuilder.and(predicate1, predicate2);
        criteriaQuery.where(predicate);
        TypedQuery<User> typedQuery =
                entityManager.createQuery(criteriaQuery);
        List<User> listUser = typedQuery.getResultList();
        if (listUser.isEmpty()){
            return null;
        }else
            return listUser.get(0);
    }


    public void update(User transientObject) {

    }


    public void delete(User persistentObject) {

    }



    public List<User> getAll() {
       // List<User> users = entityManager.createQuery("select from ", User.class).getResultList();
        return null;
    }


    public Integer create(User newUser) {
        entityManager.persist(newUser);
        String a= "";
        User user =isExistUser(newUser.getLogin(), newUser.getPassword());
        return user.getId();
    }


    public User read(Integer id) {
        return null;
    }


    public boolean isExistUserLogin(String login) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery =criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        Predicate predicate1 = criteriaBuilder.equal(root.get(User_.login), login);
        Predicate predicate = criteriaBuilder.and(predicate1);
        criteriaQuery.where(predicate);
        TypedQuery<User> typedQuery =
                entityManager.createQuery(criteriaQuery);
        List<User> listUser = typedQuery.getResultList();
        if (listUser.isEmpty()){
            return false;
        }else
            return true;
    }
}
