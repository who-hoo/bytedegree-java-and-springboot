package springbootstudy.model.network.response;

import java.time.LocalDateTime;
import lombok.*;
import springbootstudy.model.enumClass.UserStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserApiResponse {

    private Long id;

    private String account;

    private String password;

    private UserStatus status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;
}
