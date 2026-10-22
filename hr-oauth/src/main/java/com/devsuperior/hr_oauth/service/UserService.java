package com.devsuperior.hr_oauth.service;

import com.devsuperior.hr_oauth.entities.User;
import com.devsuperior.hr_oauth.feignClients.UserFeignClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClients userFeignClient;

    public User findByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();
        if(user == null){
            throw new IllegalArgumentException("Email nao encontrado");
        }
        logger.info("Email encontrado " + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(username).getBody();
        if (user == null) {
            throw new UsernameNotFoundException("Email nao encontrado: " + username);
        }
        logger.info(user + ", username: " + user.getUsername());
        return user;
    }
}
