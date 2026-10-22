package com.devsuperior.hr_oauth.service;

import com.devsuperior.hr_oauth.entities.User;
import com.devsuperior.hr_oauth.feignClients.UserFeignClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private static Logger Logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClients userFeignClient;

            public User findByEmail(String email){
                User user = userFeignClient.findByEmail(email).getBody();
                if(user == null){
                    throw new IllegalArgumentException("Email nao encontrado");
                }
                Logger.info("EMail encontrado " + email);
                return user;
            }
}
