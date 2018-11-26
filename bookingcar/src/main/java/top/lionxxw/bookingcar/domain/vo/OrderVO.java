package top.lionxxw.bookingcar.domain.vo;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Package top.lionxxw.bookingcar.domain.vo
 * Project bookingcar
 *
 * Author lionxxw
 * Created on 2017/5/19 11:21
 * version 1.0.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class OrderVO {
    private LocalDate date;
    private LocalTime time;
    private String journey;
    private BigDecimal amount;
}
