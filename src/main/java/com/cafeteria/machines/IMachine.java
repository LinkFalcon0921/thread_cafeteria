package com.cafeteria.machines;

import com.cafeteria.complements.IComplement;
import com.cafeteria.grains.IGrain;

import java.util.List;

public interface IMachine {
    boolean fillGrainStock(IGrain g);
    boolean fillGrainStock(List<IGrain> g);
    boolean fillComponentStock(IComplement c);
    boolean fillComponentStock(List<IComplement> c);
}
