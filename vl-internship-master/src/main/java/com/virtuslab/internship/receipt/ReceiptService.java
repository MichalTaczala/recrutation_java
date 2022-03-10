package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;

import com.virtuslab.internship.discount.FifteenPercentDiscount;
import com.virtuslab.internship.discount.TenPercentDiscount;
import org.springframework.stereotype.Service;



@Service
public class ReceiptService {
    Receipt createReceiptFromBasket(Basket basket){
        var receiptGenerator = new ReceiptGenerator();
        var tenPercentDiscount = new TenPercentDiscount();
        var fifteenPercentDiscount = new FifteenPercentDiscount();

        var receipt = receiptGenerator.generate(basket);
        
        var receiptAfter15PercentDiscount = fifteenPercentDiscount.apply(receipt);
        var receiptAfterBothDiscounts = tenPercentDiscount.apply(receiptAfter15PercentDiscount);

        return receiptAfterBothDiscounts;
    }
    
}
