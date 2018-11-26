package top.lionxxw.bookingcar.domain.entity;

import lombok.*;

/**
 * Package top.lionxxw.bookingcar.domain.entity
 * Project bookingcar
 *
 * Author lionxxw
 * Created on 2017/5/19 11:15
 * version 1.0.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public abstract class Entity<T> {
    T id;
    String name;
}
