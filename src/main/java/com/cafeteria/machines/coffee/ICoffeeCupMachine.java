package com.cafeteria.machines.coffee;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.IContainer;
import com.cafeteria.containers.coffee.CoffeeCup;
import com.cafeteria.containers.sizes.coffee.ECoffeeCupSize;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.grains.coffee.Coffee;
import com.cafeteria.machines.ICupMachine;

import java.util.List;

public interface ICoffeeCupMachine extends ICupMachine<CoffeeCup> {
}
