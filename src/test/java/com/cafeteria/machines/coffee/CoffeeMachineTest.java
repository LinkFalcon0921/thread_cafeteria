package com.cafeteria.machines.coffee;


import com.cafeteria.complements.EPortion;
import com.cafeteria.complements.IComplement;
import com.cafeteria.complements.Sugar;
import com.cafeteria.containers.Cup;
import com.cafeteria.containers.ESizeContainer;
import com.cafeteria.containers.IContainer;
import com.cafeteria.grains.coffee.Coffee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.Random;

class CoffeeMachineTest {

    private IMachine<Coffee> coffeeMachine;
    @BeforeEach
    void setUp() {
        this.coffeeMachine = new CoffeeMachine();
    }

    @Test
    void createSimpleCoffee() {

        Coffee coffee = new Coffee(5);
        Sugar sugar = new Sugar(new Random().nextFloat(4f), EPortion.tbsp);

        List<IComplement> complementPortions = List.of(sugar);

        IContainer cup = new Cup(ESizeContainer.ML, 15f);

        cup = this.coffeeMachine.make(coffee, cup, complementPortions);

        Assertions.assertNotNull(cup.getContent());

        System.out.println(cup.getSize());
    }
}