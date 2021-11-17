package springbootstudy.model.network.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserApiRequest {

    private Long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;
}
