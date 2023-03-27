package com.example.h2test.service;

import com.example.h2test.model.Payment;
import com.example.h2test.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentsService {
    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentsService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public void saveTenPaymentsTransactional() {
        for (int i = 0; i < 10; i++) {
            paymentRepository.savePayment(new Payment("visa", "visa-ref" + 3 + i, 20 + i, "RECORDED"));
        }
    }
    public void saveTenPayments() {
        for (int i = 0; i < 10; i++) {
            paymentRepository.savePayment(new Payment("visa", "visa-ref" + 3 + i, 20 + i, "RECORDED"));
            if (i == 6) {
                throw new RuntimeException();
            }
        }
    }

    @Transactional
    public void saveTenPaymentsTransactionalError() {
        for (int i = 0; i < 10; i++) {
            paymentRepository.savePayment(new Payment("visa", "visa-ref" + 3 + i, 20 + i, "RECORDED"));
            if (i == 6) {
                throw new RuntimeException();
            }
        }
    }

    @Transactional
    public void saveTenPaymentsTransactionalWithDelay() {
        delayAction();
        for (int i = 0; i < 10; i++) {
            paymentRepository.savePayment(new Payment("visa", "visa-ref" + 3 + i, 20 + i, "RECORDED"));
            if (i == 6) {
                throw new RuntimeException();
            }
        }
    }

    public void savePaymentsFromInside()  {
        saveTenPaymentsTransactionalError();
    }

    public int getNumberOfPayments(){
        return paymentRepository.getPaymentsNumber();
    }

    public void delayAction(){
        int sleepTimeMilis = 10000;
        try {
            System.out.println("Sleeping "+sleepTimeMilis);
            Thread.sleep(sleepTimeMilis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
