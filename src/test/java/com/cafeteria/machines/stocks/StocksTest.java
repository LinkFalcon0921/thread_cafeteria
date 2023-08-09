package com.cafeteria.machines.stocks;

import com.cafeteria.complements.Sugar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class StocksTest {
    private static Stocks stocksObj;
    private static Random random;

    @BeforeAll
    static void beforeAll() {
        random = new Random();
        stocksObj = new Stocks();
    }

    @Nested
    class fillStockTest {

        @Test
        void AddSugar() {
            checkNotNull();

            final float sugarAmount = (random.nextFloat(12)) + 5;

            Sugar sugar = new Sugar(sugarAmount);

            stocksObj.addComplements(sugar);

            assertDoesNotThrow(() -> assertTrue(stocksObj.containsStock(sugar.getType())));
        }
    }

    private void checkNotNull() {
        assumeTrue(Objects.nonNull(stocksObj),
                "Stock object is null");
    }
}