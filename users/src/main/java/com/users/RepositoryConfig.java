package com.users;

import com.users.entities.Role;
import com.users.entities.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;


@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(User.class, Role.class); //expose Id from User, Role in the response of endpoints
    }

}
