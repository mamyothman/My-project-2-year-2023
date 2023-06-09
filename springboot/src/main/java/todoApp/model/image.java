package todoApp.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="image_table")
public class image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String url;
  
}
