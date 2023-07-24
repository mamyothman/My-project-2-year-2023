package todoApp.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import todoApp.model.UserInfomation;

public interface User_infoRepository extends JpaRepository<UserInfomation,Long> {
    
    // @Query(value = "SELECT first_name FROM user_info", nativeQuery = true)
    // List<Map<String, Object>> getFirstNameAndSecondName();


    //  @Query(value = "SELECT * FROM `user_info` WHERE user_info.first_name = ?1", nativeQuery = true)
    //  List<Map<String, Object>> seach(String first_name);

}
