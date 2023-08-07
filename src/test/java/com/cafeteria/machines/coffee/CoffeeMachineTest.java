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
    private Coffee coffeeByDefault;
    private Sugar sugarByDefault;

    @BeforeEach
    void setUp() {
        Random random = new Random();

        this.coffeeMachine = new CoffeeMachine();
        this.sugarAmount = random.nextFloat(4f);
        this.coffeeByDefault = new Coffee(random.nextInt(40) * 5 + 40);
        this.sugarByDefault = new Sugar(sugarAmount * 10f);

        this.coffeeMachine.fillGrainStock(coffeeByDefault);
        this.coffeeMachine.fillComponentStock(sugarByDefault);
    }

    @Test
    void createSimpleCoffeeCupWithSugar() {

        Sugar sugar = new Sugar(EPortion.tbsp, sugarAmount);

        List<IComplement> complementPortions = List.of(sugar);

        CoffeeCup cup = this.coffeeMachine.prepareCup(EContainerSize.MEDIUM,
                complementPortions);

        assertNotNull(cup.getGrains());
        assertNotNull(cup.getComplements());

        System.out.println(cup.getSize());
    }
}