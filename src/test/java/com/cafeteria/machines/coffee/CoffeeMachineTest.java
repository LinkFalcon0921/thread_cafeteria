package com.cafeteria.machines.coffee;


import com.cafeteria.complements.EPortion;
import com.cafeteria.complements.IComplement;
import com.cafeteria.complements.Sugar;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.EMeasureContainer;
import com.cafeteria.containers.IContainer;
import com.cafeteria.grains.coffee.Coffee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CoffeeMachineTest {

    private IMachine<Coffee> coffeeMachine;
    private float sugarAmount;

    @BeforeEach
    void setUp() {
        this.coffeeMachine = new CoffeeMachine();
        this.sugarAmount = new Random().nextFloat(4f);
    }

    @Test
    void createSimpleCoffeeWithSugar() {

        Coffee coffee = new Coffee(5);
        Sugar sugar = new Sugar(sugarAmount, EPortion.tbsp);

        List<IComplement> complementPortions = List.of(sugar);

        IContainer cup = this.coffeeMachine.make(EContainerType.CUP,
                EContainerSize.MEDIUM,
                coffee,
                complementPortions);

        assertNotNull(cup.getGrains());

        System.out.println(cup.getSize());
    }
}