package todoApp.dto;

import lombok.Data;

@Data
public class imageDTO {
  private String filename;
  private String url;
  private String type;
  private long size;

  public imageDTO(String filename,String url,String type,long size){
    this.filename = filename;
    this.url = url;
    this.type = type;
    this.size = size;
  }

  public imageDTO(){
    
  }
}
