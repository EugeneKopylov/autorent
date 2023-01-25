package it.academy.dtos.dto.car;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {

    String orderDateFrom;
    String orderDateTo;
    String cost;

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderDateFrom='" + orderDateFrom + '\'' +
                ", orderDateTo='" + orderDateTo + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}
