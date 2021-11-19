package springbootstudy.model.network.response;

import java.time.LocalDateTime;
import lombok.*;
import springbootstudy.model.enumClass.PartnerStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartnerApiResponse {

    private Long id;

    private String name;

    private PartnerStatus status;

    private String address;

    private String callCenter;

    private String partnerNumber;

    private String businessNumber;

    private String ceoName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private Long categoryId;
}
