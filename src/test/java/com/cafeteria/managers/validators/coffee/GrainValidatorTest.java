package com.cafeteria.managers.validators.coffee;

import com.cafeteria.grains.IGrain;
import com.cafeteria.grains.coffee.Coffee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class GrainValidatorTest {

    private interface IMessages {

        String THE_VALIDATOR_IS_NULL_MESSAGE = "The validator is null";
        String THERE_IS_NOT_ENOUGH_GRAIN_IN_THE_STOCK = "There is not enough grain in the stock.";
    }

    private static GrainValidator validator;
    private static Random randomizer;

    @BeforeAll
    static void beforeAll() {
        validator = new GrainValidator();
        randomizer = new Random();
    }

    @Test
    void checkStockIsAvailable() {

        checkValidatorNotNull();

        final int maxAmount = 20;

        final int coffeeAmount = randomizer.nextInt(maxAmount) + maxAmount;

        Optional<IGrain> grainOptional = Optional.of(new Coffee(coffeeAmount));

        final int expectedAmount = randomizer.nextInt(maxAmount);

        assertTrue(validator.isThereEnough(grainOptional, expectedAmount));
    }

    @Test
    void checkFailStock() {

        checkValidatorNotNull();

        final int coffeeAmount = 0;

        Optional<IGrain> grainOptional = Optional.of(new Coffee(coffeeAmount));

        final int expectedAmount = randomizer.nextInt(3);

        assertFalse(validator.isThereEnough(grainOptional, expectedAmount),
                IMessages.THERE_IS_NOT_ENOUGH_GRAIN_IN_THE_STOCK);
    }

    private static void checkValidatorNotNull() {
        assumeTrue(Objects.nonNull(validator),
                IMessages.THE_VALIDATOR_IS_NULL_MESSAGE);
    }
}