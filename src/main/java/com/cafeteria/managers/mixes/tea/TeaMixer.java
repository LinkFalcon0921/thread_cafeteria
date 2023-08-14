package com.cafeteria.managers.mixes.tea;

import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.tea.Tea;
import com.cafeteria.managers.mixes.Mixer;

public class TeaMixer extends Mixer<ETeaMix, Tea> {
    public TeaMixer() {
        super(EGrainsType.TEA);
    }

}
