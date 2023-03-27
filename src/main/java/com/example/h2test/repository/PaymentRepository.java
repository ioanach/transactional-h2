package com.example.h2test.repository;

import com.example.h2test.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentRepository  {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PaymentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void savePayment(Payment payment){
        String sql = "INSERT INTO PAYMENT(brand, reference,amount, status) VALUES (?,?,?,?)";
        Object[] args = {payment.getBrandName(), payment.getReference(), payment.getAmount(), payment.getStatus()};
        jdbcTemplate.update(sql, args);
    }

    public int getPaymentsNumber(){
        return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM PAYMENT", Integer.class);
    }

}
