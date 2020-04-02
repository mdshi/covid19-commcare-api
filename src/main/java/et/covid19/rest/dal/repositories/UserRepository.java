<<<<<<< HEAD
package et.covid19.rest.dal.repositories;

import et.covid19.rest.dal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
=======
package et.covid19.rest.dal.repositories;

import et.covid19.rest.dal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String email);
}
>>>>>>> 112155b85c5517eb9d3ee9ba0f6afa2aa4bdebea
