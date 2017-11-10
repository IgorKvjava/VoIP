package ua.kvelinskyi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kvelinskyi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {


    User findByLoginAndPassword(String login, String password);
    boolean findByLogin(String login);
}
