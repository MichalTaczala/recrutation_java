package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptServiceTest {
    @Test
    void shouldGiveReceiptWithAppliedDiscounts(){
        var service = new ReceiptService();

        var basket = new Basket();
        basket.addProduct(new Product("Steak", Product.Type.MEAT, BigDecimal.valueOf(50)));
        basket.addProduct(new Product("Steak", Product.Type.MEAT, BigDecimal.valueOf(50)));

        var result = service.createReceiptFromBasket(basket);

        var expectedTotalPrice = BigDecimal.valueOf(50).add(BigDecimal.valueOf(50)).multiply(BigDecimal.valueOf(0.9));

        assertEquals(expectedTotalPrice, result.totalPrice());
        assertEquals(1, result.entries().size());
        assertEquals(1, result.discounts().size());
    }
}
