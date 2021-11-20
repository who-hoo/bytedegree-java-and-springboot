package com.fastcampus.faststore.entity;

import com.fastcampus.faststore.type.DiscountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
/**
 * 할인 정책 Entity
 * 할인 타입과 액수를 가진다
 */
public class DiscountPolicy extends BaseEntity {

    private DiscountType discountType;

    private Long amount;

    public Long getDiscountAmount(Long price) {
        // 할인 정책이 PERCENT, AMOUNT 외에도 추가될 수 있어 if로 분기하였습니다.
        if (discountType == DiscountType.PERCENT) {
            return price - (price * amount / 100L);
        }

        if (discountType == DiscountType.AMOUNT) {
            return price - amount;
        }

        return price;
    }
}
