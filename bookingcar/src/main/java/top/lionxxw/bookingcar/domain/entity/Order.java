package top.lionxxw.bookingcar.domain.entity;

import top.lionxxw.bookingcar.domain.vo.OrderVO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Package top.lionxxw.bookingcar.domain.entity
 * Project bookingcar
 *
 * Author lionxxw
 * Created on 2017/5/19 11:25
 * version 1.0.0
 */

public class Order extends Entity<String> {
    private OrderVO orderVo = new OrderVO();
    private final String userId;
    private final String driverId;

    /**
     *
     * @param name
     * @param id
     * @param userId;
     * @param driverId;
     * @param journey
     * @param date
     * @param time
     * @param amount
     */
    public Order(String id, String name, String userId, String driverId,
                 String journey, LocalDate date, LocalTime time, BigDecimal amount) {
        super(id, name);
        this.userId = userId;
        this.driverId = driverId;
        this.orderVo.setJourney(journey);
        this.orderVo.setDate(date);
        this.orderVo.setTime(time);
        this.orderVo.setAmount(amount);
    }


    /**
     *
     * @return
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     *
     * @return
     */
    public LocalDate getDate() {
        return this.orderVo.getDate();
    }

    /**
     *
     * @param date
     */
    public void setDate(LocalDate date) {
        this.orderVo.setDate(date);
    }

    /**
     *
     * @return
     */
    public LocalTime getTime() {
        return this.orderVo.getTime();
    }

    /**
     *
     * @param time
     */
    public void setTime(LocalTime time) {
        this.orderVo.setTime(time);
    }

    /**
     *
     * @return
     */
    public String getJourney() {
        return this.orderVo.getJourney();
    }

    /**
     *
     * @param journey
     */
    public void setJourney(String journey) {
        this.orderVo.setJourney(journey);
    }

    /**
     *
     * @return
     */
    public BigDecimal getAmount() {
        return this.orderVo.getAmount();
    }

    /**
     *
     * @param amount
     */
    public void setAmount(BigDecimal amount) {
        this.orderVo.setAmount(amount);
    }


    /**
     * Overridden toString() method that return String presentation of the
     * Object
     *
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(this.id)
                .append(", name: ").append(this.name)
                .append(", userId: ").append(this.userId)
                .append(", driverId: ").append(this.driverId)
                .append(this.orderVo.toString())
                .append("}").toString();
    }
}
