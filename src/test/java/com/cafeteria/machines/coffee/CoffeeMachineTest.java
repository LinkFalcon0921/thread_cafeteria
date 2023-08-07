package com.cafeteria.machines.coffee;


import com.cafeteria.complements.EPortion;
import com.cafeteria.complements.IComplement;
import com.cafeteria.complements.Sugar;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.coffee.CoffeeCup;
import com.cafeteria.grains.coffee.Coffee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CoffeeMachineTest {

    private CoffeeMachine coffeeMachine;
    private float sugarAmount;

    @BeforeEach
    void setUp() {
        this.coffeeMachine = new CoffeeMachine();
        this.sugarAmount = new Random().nextFloat(4f);
    }

    @Test
    void createSimpleCoffeeCupWithSugar() {

        Coffee coffee = new Coffee(5);
        Sugar sugar = new Sugar(sugarAmount, EPortion.tbsp);

        List<IComplement> complementPortions = List.of(sugar);

        CoffeeCup cup = this.coffeeMachine.prepareCup(EContainerSize.MEDIUM,
                complementPortions);

        assertNotNull(cup.getGrains());

        System.out.println(cup.getSize());
    }
}