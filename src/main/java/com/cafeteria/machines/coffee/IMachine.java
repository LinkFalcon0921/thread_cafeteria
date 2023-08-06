package com.cafeteria.machines.coffee;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.IContainer;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.grains.IGrains;

import java.util.List;

/**
 * @param <G> Grains Enum
 */
public interface IMachine<G extends IGrains, ES extends Enum<ES>> {
}
