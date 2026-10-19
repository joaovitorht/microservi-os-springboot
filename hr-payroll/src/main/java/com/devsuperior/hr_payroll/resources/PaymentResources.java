package com.devsuperior.hr_payroll.resources;

import com.devsuperior.hr_payroll.entities.Payment;
import com.devsuperior.hr_payroll.feignclients.WorkerServiceUnavailableException;
import com.devsuperior.hr_payroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/payments")
public class PaymentResources {

    @Autowired
    private PaymentService service;

    @GetMapping(value ="/{workerId}/days/{days}")
    public ResponseEntity<Payment>getPayment(@PathVariable long workerId, @PathVariable Integer days){
        try {
            Payment payment = service.getPayment(workerId, days);
            return ResponseEntity.ok(payment);
        } catch (WorkerServiceUnavailableException e) {
            return getPaymentAlternative(workerId, days);
        }
    }

    private ResponseEntity<Payment> getPaymentAlternative(long workerId, Integer days){
        Payment payment = new Payment("minhapessoa",400.0,  days);
        return ResponseEntity.ok(payment);
    }

}
