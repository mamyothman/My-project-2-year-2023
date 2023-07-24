package todoApp.model;


import jakarta.persistence.Column;
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
    private Long image_id;
    private String image_name;
    private String image_typ;
    @Column(length = 50000000)
    private byte[] image_byte;
    public image(String image_name, String image_typ, byte[] image_byte) {
        this.image_name = image_name;
        this.image_typ = image_typ;
        this.image_byte = image_byte;
    }

      public image(){}
    

    
  
}
