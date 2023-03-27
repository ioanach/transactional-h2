package com.example.h2test.controller;

import com.example.h2test.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    PaymentsController(PaymentsService paymentsService){
        this.paymentsService = paymentsService;
    }

    @GetMapping("/payments/save")
    int savePayments(){
        paymentsService.saveTenPayments();
        return paymentsService.getNumberOfPayments();
    }
    //TODO : fix for current issue
    @GetMapping("/payments/saveTransactionalError")
    int savePaymentsTransactionalError(){
        paymentsService.delayAction();
        paymentsService.saveTenPaymentsTransactionalError();
        return paymentsService.getNumberOfPayments();
    }

    @GetMapping("/payments/saveTransactional")
    int savePaymentsTransactional(){
        paymentsService.delayAction();
        paymentsService.saveTenPaymentsTransactional();
        return paymentsService.getNumberOfPayments();
    }

//TODO : current issue
    @GetMapping("/payments/saveTransactionalDelay")
    int savePaymentsTransactionalWithDelay(){
        paymentsService.saveTenPaymentsTransactionalWithDelay();
        return paymentsService.getNumberOfPayments();
    }

    @GetMapping("/payments/saveInside")
    int savePaymentsFromInside(){
        paymentsService.savePaymentsFromInside();
        return paymentsService.getNumberOfPayments();
    }
}
