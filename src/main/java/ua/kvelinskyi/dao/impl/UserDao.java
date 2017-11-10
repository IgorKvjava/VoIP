package ua.kvelinskyi.dao.impl;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.transaction.annotation.Transactional;
import ua.kvelinskyi.entity.User;

import java.util.List;

@Component
@Transactional
public class UserDao {
    public static final Logger LOGGER = LogManager.getLogger("ua.kvelinskyi.loggers.core");

    @PersistenceContext
    EntityManager entityManager;

    public User isExistUser(String login, String pass) {
        LOGGER.info("UserDao, isExistUser has started !");
       /* CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        Predicate predicate1 = criteriaBuilder.equal(root.get(User_.login), login);
        Predicate predicate2 = criteriaBuilder.equal(root.get(User_.password), pass);
        Predicate predicate = criteriaBuilder.and(predicate1, predicate2);
        criteriaQuery.where(predicate);
        TypedQuery<User> typedQuery =
                entityManager.createQuery(criteriaQuery);
        List<User> listUser = typedQuery.getResultList();
        if (listUser.isEmpty()) {
            return null;
        } else*/
            return null;
    }


    public Integer create(User newUser) {
        entityManager.persist(newUser);
        User user = isExistUser(newUser.getLogin(), newUser.getPassword());
        return user.getId();
    }

    public boolean isExistUserLogin(String login) {
       /* CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        Predicate predicate1 = criteriaBuilder.equal(root.get(User_.login), login);
        Predicate predicate = criteriaBuilder.and(predicate1);
        criteriaQuery.where(predicate);
        TypedQuery<User> typedQuery =
                entityManager.createQuery(criteriaQuery);
        List<User> listUser = typedQuery.getResultList();
        if (listUser.isEmpty()) {
            return false;
        } else*/
            return true;
    }

    public User update(User transientObject) {
        int idUser = transientObject.getId();
        entityManager.merge(transientObject);
        return entityManager.find(User.class, idUser);
    }

    public void delete(User persistentObject) {

    }

    public List<User> getAll() {
      // List<User> resultList = entityManager.createQuery("FROM springUser", User.class).getResultList();
        /*CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery =criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        TypedQuery<User> typedQuery =
                entityManager.createQuery(criteriaQuery);
        List<User> resultList =   typedQuery.getResultList();*/
        return null;
    }

    public User read(Integer id) {
        return null;
    }
//TODO delete isExistAdmin
    /*public boolean isExistAdmin(String role) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        Predicate predicate1 = criteriaBuilder.equal(root.get(User_.role), role);
        Predicate predicate = criteriaBuilder.and(predicate1);
        criteriaQuery.where(predicate);
        TypedQuery<User> typedQuery =
                entityManager.createQuery(criteriaQuery);
        List<User> listUser = typedQuery.getResultList();
        if (listUser.isEmpty()) {
            return false;
        } else
            return true;
    }*/
}
