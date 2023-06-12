package todoApp.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="image_table")
public class image {
    @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String filename;
    private String type;
    private byte[] data;

   public image(String filename, String type, byte[] data){
    this.filename = filename;
    this.type = type;
    this.data = data;
   }
   public image(){
    
   }
}
