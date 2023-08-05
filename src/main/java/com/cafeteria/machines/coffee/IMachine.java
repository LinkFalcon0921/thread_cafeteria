package com.cafeteria.machines.coffee;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.IContainer;
import com.cafeteria.grains.IGrains;

import java.util.List;

public interface IMachine<G extends IGrains> {
    IContainer make(final G grains, final IContainer container, final List<IComplement> complement);
}
