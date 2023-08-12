package com.cafeteria.machines;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.IContainer;
import com.cafeteria.grains.IGrain;
import com.cafeteria.managers.builders.coffee.IContainerBuilder;
import lombok.NonNull;

import java.util.List;

public interface IMachine{
    boolean fillGrainStock(IGrain g);

    boolean fillGrainStock(List<IGrain> g);

    boolean fillComponentStock(IComplement c);

    boolean fillComponentStock(List<IComplement> c);

    void restart();
}
