package org.meliades.repository;

import org.meliades.beans.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

/**
 * Created by Fred on 20/04/2015.
 */
@RepositoryRestResource(path = "users")
public interface UserRepository extends MongoRepository<User, Long> {

    @RestResource(path = "username")
    Collection<User> findByNom(@Param("name") String nom);

    User findByPrenom(String prenom);

}
