package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ReceiptGenerator {

    public Receipt generate(Basket basket) {
        var receipt = getReceipt(basket);
        return receipt;
    }

    private Receipt getReceipt(Basket basket) {
        List<ReceiptEntry> receiptEntries = new ArrayList<>();

        HashSet<Product> uniqueProducts = new HashSet<Product>(basket.getProducts());
        receiptEntries = uniqueProducts.stream().map(product -> new ReceiptEntry(product, Collections.frequency(basket.getProducts(), product))).collect(Collectors.toList());

        return new Receipt(receiptEntries);
    }
}
