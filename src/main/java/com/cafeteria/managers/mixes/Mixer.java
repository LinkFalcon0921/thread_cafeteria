package com.cafeteria.managers.mixes;

import com.cafeteria.exceptions.containers.creators.IssueMachineExceptionCreator;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.IGrain;

import java.util.Optional;

public abstract class Mixer<E_MIX extends IGrainMixDetails, G extends IGrain>
        implements IMixer<E_MIX, G> {

    protected static IssueMachineExceptionCreator EXCEPTION_CREATOR;
    protected final EGrainsType type;

    public Mixer(EGrainsType grainType) {
        EXCEPTION_CREATOR = IssueMachineExceptionCreator.getCreator();
        this.type = grainType;
    }

    @Override
    public float mixGrains(E_MIX e, Optional<G> grainOptional) {
        if (grainOptional.isEmpty()) {
            throw EXCEPTION_CREATOR.createNoEnoughStockException(this.type);
        }

        return grainOptional.get().getAmount() * e.getMixVal();
    }
}
