package ua.kvelinskyi.dao.impl;

import org.springframework.stereotype.Component;
import ua.kvelinskyi.dao.interfaces.Dao;

import java.io.Serializable;
import java.util.List;

@Component
public class UserDao <User, Integer extends Serializable> implements Dao<User, Integer> {

    @Override
    public void update(User transientObject) {

    }

    @Override
    public void delete(User persistentObject) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Integer create(User newInstance) {
        return null;
    }

    @Override
    public User read(Integer id) {
        return null;
    }
}
