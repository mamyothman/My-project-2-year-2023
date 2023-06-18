package todoApp.model;
import lombok.Data;

@Data
public class FileInfo {
//   @Id
//   @GeneratedValue(generator = "uuid")
//   @GenericGenerator(name = "uuid", strategy = "uuid2")

 
  private String name;
  private String url;

  public FileInfo(String name, String url) {
    this.name = name;
    this.url = url;
   
  }

//   public String getName() {
//     return this.name;
//   }

//   public void setName(String name) {
//     this.name = name;
//   }

//   public String getUrl() {
//     return this.url;
//   }

//   public void setUrl(String url) {
//     this.url = url;
//   }


}