package com.virtuslab.internship.receipt;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.LinkedList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ReceiptController.class)
public class ReceiptControllerTest {
    @MockBean
    private ReceiptService receiptService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;



    @Test
    void shouldReturnStatus200() throws  Exception {
        var basket = new Basket();
        basket.addProduct(new Product("Steak", Product.Type.MEAT, BigDecimal.valueOf(50)));

        mockMvc.perform(post("/api/v1/receipts/createFromBasket")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(basket)))
                .andExpect(status()
                        .isOk());
    }
}
