package com.cafeteria.managers.factories.getters.containers.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.IContainerSize;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.managers.factories.getters.containers.GrainContainerGetterManager;
import com.cafeteria.managers.factories.getters.containers.IGrainContainerGetterManager;
import org.jetbrains.annotations.NotNull;

public class CoffeeContainerGetterManager extends GrainContainerGetterManager {

    private final CoffeeGlassContainerGetter glassContainerGetter;
    private final CoffeeCupContainerGetter cupContainerGetter;

    public CoffeeContainerGetterManager() {
        super();
        glassContainerGetter = new CoffeeGlassContainerGetter();
        cupContainerGetter = new CoffeeCupContainerGetter();
    }

    @Override
    public IContainerSize getGrainContainerDetails(@NotNull EContainerType containerType,
                                                   @NotNull EContainerSize containerSize)
            throws IssueMachineException {

        return switch (containerType) {
            // In case is a CUP
            case CUP -> this.cupContainerGetter.getDetailsOf(containerSize);

            // In case is a GLASS
            case GLASS -> this.glassContainerGetter.getDetailsOf(containerSize);

            default -> throw EXCEPTION_CREATOR.createUnsupportedContainerSizeException();
        };
    }
}
