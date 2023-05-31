package todoApp.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import todoApp.model.login;

public interface loginRepository extends JpaRepository<login,Long> {
    boolean findByUsername(String username);
    Optional<login> getByUsername(String username);


 
}
