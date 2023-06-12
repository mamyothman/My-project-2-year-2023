package todoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import todoApp.model.image;

public interface ImageRepository  extends JpaRepository<image,String>{
    
}
