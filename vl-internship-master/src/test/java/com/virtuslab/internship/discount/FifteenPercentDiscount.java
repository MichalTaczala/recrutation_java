package com.virtuslab.internship.discount;

import com.virtuslab.internship.receipt.Receipt;

import java.math.BigDecimal;

public class FifteenPercentDiscount {
    public static String NAME = "FifteenPercentDiscount";

    public Receipt apply(Receipt receipt) {
        if (shouldApply(receipt)) {
            var totalPrice = receipt.totalPrice().multiply(BigDecimal.valueOf(0.85));
            var discounts = receipt.discounts();
            discounts.add(NAME);
            return new Receipt(receipt.entries(), discounts, totalPrice);
        }
        return receipt;
    }

    private boolean shouldApply(Receipt receipt) {
        var quantityOfProducts = receipt.entries().stream().mapToInt(o->o.quantity()).sum();
        return receipt.discounts().size() == 0 && quantityOfProducts >= 3;
        //first condidtion - only aply when 10percent discount is not included yet
        //second condition - aply 15percent discount if there are 3 or more items on the receipt
    }
}
