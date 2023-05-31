package todoApp.dto;

import lombok.Data;

@Data
public class loginDTO {
    private long id;
    private String username;
    private String roles;
    private int status;
}
