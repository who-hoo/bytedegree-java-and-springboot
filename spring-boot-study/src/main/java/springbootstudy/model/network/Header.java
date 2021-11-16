package springbootstudy.model.network;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header<T> {

    private String transactionTime;

    private String resultCode;

    private String description;

    private T data;
}
