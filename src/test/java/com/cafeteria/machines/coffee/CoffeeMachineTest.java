package com.cafeteria.machines.coffee;


import com.cafeteria.complements.EPortion;
import com.cafeteria.complements.IComplement;
import com.cafeteria.complements.Sugar;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.coffee.CoffeeCup;
import com.cafeteria.grains.coffee.Coffee;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class CoffeeMachineTest {

    interface IMessageTest {
        String COFFEE_MACHINE_NULL_MESSAGE = "Coffee machine is null in this point.";

    }

    private static CoffeeMachine coffeeMachine;
    private static float sugarAmount;

    @BeforeAll
    static void setUp() {
        Random random = new Random();

        coffeeMachine = new CoffeeMachine();
        sugarAmount = random.nextFloat(4f);
        Coffee coffeeByDefault = new Coffee(random.nextInt(100) + 100);
        Sugar sugarByDefault = new Sugar(sugarAmount * 10f);

        coffeeMachine.fillGrainStock(coffeeByDefault);
        coffeeMachine.fillComplementStock(sugarByDefault);
    }

    @Nested
    @Order(1)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class CupPreparation {
        @Test
        @Order(1)
        void createSmallCoffeeCupWithSugar() {

            Sugar sugar = new Sugar(EPortion.tbsp, sugarAmount);

            List<IComplement> complementPortions = List.of(sugar);

            CoffeeCup cup = coffeeMachine.prepareCup(EContainerSize.SMALL,
                    complementPortions);

            assertNotNull(cup.getGrains());
            assertNotNull(cup.getComplements());

            System.out.println(cup.getSize());
        }

        @Test
        @Order(2)
        void createMediumCoffeeCupWithSugar() {

            Sugar sugar = new Sugar(EPortion.tbsp, sugarAmount);

            List<IComplement> complementPortions = List.of(sugar);

            CoffeeCup cup = coffeeMachine.prepareCup(EContainerSize.MEDIUM,
                    complementPortions);

            assertNotNull(cup.getGrains());
            assertNotNull(cup.getComplements());

            System.out.println(cup.getSize());
        }

    }

    @Test
    @Order(3)
    void createBigCoffeeCupWithSugar() {

        Sugar sugar = new Sugar(EPortion.tbsp, sugarAmount);

        List<IComplement> complementPortions = List.of(sugar);

        CoffeeCup cup = coffeeMachine.prepareCup(EContainerSize.BIG,
                complementPortions);

        assertNotNull(cup.getGrains());
        assertNotNull(cup.getComplements());

        System.out.println(cup.getSize());
    }

    @Nested
    @Order(999)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class CleanActionMachine {

        @Test
        @Order(1)
        void cleanMachineStocks() {
            checkCoffeeMachineNotNull();
            assertDoesNotThrow(CoffeeMachineTest.coffeeMachine::restart);
        }
    }

    private static void checkCoffeeMachineNotNull() {
        assertNotNull(CoffeeMachineTest.coffeeMachine, IMessageTest.COFFEE_MACHINE_NULL_MESSAGE);
    }

}