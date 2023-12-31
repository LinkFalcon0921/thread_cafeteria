package com.cafeteria.managers.validators.grains;

import com.cafeteria.grains.IGrain;
import com.cafeteria.grains.coffee.Coffee;
import org.junit.jupiter.api.*;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GrainValidatorTest {

//    protected static final EContainerSize MEDIUM_SIZE_CONTAINER = EContainerSize.MEDIUM;
//    protected static final EContainerType CUP_CONTAINER = EContainerType.CUP;
//    private CoffeeContainerGetterManager containerGetterManager;

    private interface IMessages {

        //  String REQUIRED_INGREDIENTS_WERE_NOT_FOUND_MESSAGE = "The container required ingredients were not found";

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

    @Order(1)
    @RepeatedTest(5)
    void checkStockIsAvailable() {

        checkValidatorNotNull();

        final int maxAmount = 20;

        final int coffeeAmount = randomizer.nextInt(maxAmount) + maxAmount;

        Optional<IGrain> grainOptional = Optional.of(new Coffee(coffeeAmount));

        final int expectedAmount = randomizer.nextInt(maxAmount);

        assertTrue(validator.hasEnough(grainOptional, expectedAmount));
    }

    @Order(2)
    @RepeatedTest(3)
    void checkFailStock() {

        checkValidatorNotNull();

        final int coffeeAmount = 0;

        Optional<IGrain> grainOptional = Optional.of(new Coffee(coffeeAmount));

        int expectedGrain = 3;
        final int expectedAmount = randomizer.nextInt(expectedGrain) + expectedGrain;

        assertFalse(validator.hasEnough(grainOptional, expectedAmount),
                IMessages.THERE_IS_NOT_ENOUGH_GRAIN_IN_THE_STOCK);
    }

    private static void checkValidatorNotNull() {
        assumeTrue(Objects.nonNull(validator),
                IMessages.THE_VALIDATOR_IS_NULL_MESSAGE);
    }
}