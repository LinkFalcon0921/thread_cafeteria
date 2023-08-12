package com.cafeteria.managers.validators.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.IContainerSize;
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

    protected static final EContainerSize MEDIUM_SIZE_CONTAINER = EContainerSize.MEDIUM;
    protected static final EContainerType CUP_CONTAINER = EContainerType.CUP;
    private interface IMessages {

        String REQUIRED_INGREDIENTS_WERE_NOT_FOUND_MESSAGE = "The container required ingredients were not found";

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

    @Test
    void checkGetRequiredIngredientsNotNull() {
        checkValidatorNotNull();

        IContainerSize requiredGrain = validator
                .getRequiredGrain(CUP_CONTAINER, MEDIUM_SIZE_CONTAINER);

        assertNotNull(requiredGrain, IMessages.REQUIRED_INGREDIENTS_WERE_NOT_FOUND_MESSAGE);
    }

    private static void checkValidatorNotNull() {
        assumeTrue(Objects.nonNull(validator),
                IMessages.THE_VALIDATOR_IS_NULL_MESSAGE);
    }
}