package ua.kvelinskyi.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.kvelinskyi.dao.impl.UserDao;

@EnableJpaRepositories
@Configuration
@EnableTransactionManagement
public class DataConfig {

    @Bean
    public UserDao getUserDao() {
        return new UserDao();
    }

}
