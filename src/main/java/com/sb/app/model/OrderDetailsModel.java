package com.sb.app.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderDetailsModel {
    private int orderId;
    private String orderName;
    private int orderPrice;
}
