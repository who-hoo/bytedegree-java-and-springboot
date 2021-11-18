package springbootstudy.model.network.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;
import springbootstudy.model.enumClass.ItemStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemApiResponse {

    private Long id;

    private ItemStatus status;

    private String name;

    private String title;

    private String content;

    private BigDecimal price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private Long partnerId;
}
