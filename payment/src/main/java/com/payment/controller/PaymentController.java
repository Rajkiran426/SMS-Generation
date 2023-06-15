package com.payment.controller;

import com.payment.services.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    


    @PostMapping("/create-order")
    public String createOrder(@RequestParam("amount") int amount, @RequestParam("currency") String currency) throws RazorpayException {
        String orderId = paymentService.createOrder(amount, currency);
        return "Order created with ID: " + orderId;
    }

    @PostMapping("/verify-signature")
    public String verifyPaymentSignature(@RequestParam String orderId, @RequestParam String paymentId, @RequestParam String signature) throws RazorpayException {
        return paymentService.verifyPaymentSignature(orderId, paymentId, signature);
    }
}


