package todoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import todoApp.model.UserInfomation;

public interface User_infoRepository extends JpaRepository<UserInfomation,Long> {
    
}
