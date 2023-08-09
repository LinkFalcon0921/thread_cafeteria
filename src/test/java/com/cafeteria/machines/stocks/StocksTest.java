package com.cafeteria.machines.stocks;

import com.cafeteria.complements.Sugar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class StocksTest {

    private interface IMessages {
        String STOCK_OBJECT_IS_NULL_MESSAGE = "Stock object is null";
        String THERE_IS_ANY_SUGAR_MESSAGE = "There is any sugar";
    }

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

            assertTrue(stocksObj.addComplements(sugar));

            assertDoesNotThrow(
                    () -> assertTrue(stocksObj.containsStock(sugar.getType()),
                            IMessages.THERE_IS_ANY_SUGAR_MESSAGE)
            );
        }
    }

    @Nested
    class CleanupTest{
        @Test
        void cleanStocks() {
            checkNotNull();

            final float sugarAmount = (random.nextFloat(12)) + 5;

            Sugar sugar = new Sugar(sugarAmount);

            assertTrue(stocksObj.addComplements(sugar));

            stocksObj.cleanUp();
        }
    }

    private void checkNotNull() {
        assumeTrue(Objects.nonNull(stocksObj),
                IMessages.STOCK_OBJECT_IS_NULL_MESSAGE);
    }
}