package com.example.projectc1023i1.repository.product;

import com.example.projectc1023i1.model.product.Order;
import com.example.projectc1023i1.model.product.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
    List<OrderDetails> findByTableId(int tableId);
    List<OrderDetails> findByOrder(Order order);

    @Query("SELECT od FROM OrderDetails od WHERE od.order.orderId = :orderId")
    List<OrderDetails> findByOrderId(@Param("orderId") Integer orderId);

    @Query("SELECT SUM(od.totalMoneyOrder) FROM OrderDetails od WHERE od.order.orderId = :orderId")
    Double sumTotalMoneyOrderByOrderId(@Param("orderId") Integer orderId);

    @Query("SELECT SUM(od.quantity) FROM OrderDetails od WHERE od.order.orderId = :orderId")
    Integer sumQuantityByOrderId(@Param("orderId") Integer orderId);
    @Query(value = "SELECT * FROM order_details WHERE table_id = :tableId", nativeQuery = true)
    List<OrderDetails> findOrderDetailsByTableId(@Param("tableId") int tableId);

    @Query("SELECT od FROM OrderDetails od WHERE od.orderDetailId = :orderDetailsId")
    List<OrderDetails> findByOrderDetailsId(@Param("orderDetailsId") Integer orderDetailsId);

    @Query("SELECT SUM(od.totalMoneyOrder) FROM OrderDetails od WHERE od.shippingDay BETWEEN :from AND :to")
    Integer sumTotalByDate(LocalDateTime from, LocalDateTime to);

    @Query(value = "SELECT HOUR(od.shipping_day) AS period, SUM(od.total_money_order) AS totalIncome " +
            "FROM order_details od " +
            "WHERE DATE(od.shipping_day) = CURRENT_DATE " +
            "GROUP BY HOUR(od.shipping_day)",
            nativeQuery = true)
    List<Object[]> getIncomeByHourToday();

    @Query(value = "SELECT DAY(od.shipping_day) AS period, SUM(od.total_money_order) AS totalIncome " +
            "FROM order_details od " +
            "WHERE MONTH(od.shipping_day) = MONTH(CURRENT_DATE) AND YEAR(od.shipping_day) = YEAR(CURRENT_DATE) " +
            "GROUP BY DAY(od.shipping_day)",
            nativeQuery = true)
    List<Object[]> getIncomeByDayInMonth();

    @Query(value = "SELECT DAYOFWEEK(od.shipping_day) AS period, SUM(od.total_money_order) AS totalIncome " +
            "FROM order_details od " +
            "WHERE YEARWEEK(od.shipping_day, 1) = YEARWEEK(CURRENT_DATE, 1) " +
            "GROUP BY DAYOFWEEK(od.shipping_day)",
            nativeQuery = true)
    List<Object[]> getIncomeByDayInWeek();
    //
    @Query(value = "SELECT MONTH(od.shipping_day) AS period, SUM(od.total_money_order) AS totalIncome " +
            "FROM order_details od " +
            "WHERE YEAR(od.shipping_day) = YEAR(CURRENT_DATE) " +
            "GROUP BY MONTH(od.shipping_day)",
            nativeQuery = true)
    List<Object[]> getIncomeByMonthInYear();
    @Query(value = """
    SELECT
        CASE
            WHEN DATEDIFF(:toDate, :fromDate) = 0 THEN HOUR(od.shipping_day)
            WHEN DATEDIFF(:toDate, :fromDate) BETWEEN 2 AND 31 THEN DAY(od.shipping_day)
            WHEN DATEDIFF(:toDate, :fromDate) BETWEEN 32 AND 366 THEN MONTH(od.shipping_day)
            ELSE YEAR(od.shipping_day)
        END AS period,
        SUM(od.total_money_order) AS totalIncome
    FROM order_details od
    WHERE od.shipping_day BETWEEN :fromDate AND :toDate
    GROUP BY
        CASE
            WHEN DATEDIFF(:toDate, :fromDate) = 0 THEN HOUR(od.shipping_day)
            WHEN DATEDIFF(:toDate, :fromDate) BETWEEN 2 AND 31 THEN DAY(od.shipping_day)
            WHEN DATEDIFF(:toDate, :fromDate) BETWEEN 32 AND 366 THEN MONTH(od.shipping_day)
            ELSE YEAR(od.shipping_day)
        END
    """, nativeQuery = true)
    List<Object[]> getIncomeByRange(@Param("fromDate") LocalDateTime fromDate, @Param("toDate") LocalDateTime toDate);
    //
    @Query(value = "SELECT SUM(od.totalMoneyOrder) FROM OrderDetails od WHERE od.shippingDay BETWEEN :from AND :to")
    List<Object[]> getIncomeByDateRange(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);
}
