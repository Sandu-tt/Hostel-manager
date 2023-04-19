package lk.ijse.dto;

import lk.ijse.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO extends SuperDTO {
    private int id;
    private String username;
    private String password;

    public User toUserDTO() {
        return new User(this.id, this.username, this.password);
    }
}
