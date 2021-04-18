package com.users.repositories;


import com.users.entities.User;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="user")// endpoint with data rest
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    public User findByUsername(@Param("username") String username);

                        //class                  //param 1, 2 ,...
    @Query("select u from User u where u.username=?1")
    public User obtenerPorUsername(String username);


}
