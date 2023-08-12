package com.cafeteria.managers.factories.getters.containers.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.IContainerSize;
import com.cafeteria.managers.factories.getters.containers.IGrainContainerGetterManager;
import org.jetbrains.annotations.NotNull;

public class CoffeeContainerGetterManager implements IGrainContainerGetterManager {
    private final CoffeeGlassContainerGetter glassContainerGetter;
    private final CoffeeCupContainerGetter cupContainerGetter;

    public CoffeeContainerGetterManager() {
        glassContainerGetter = new CoffeeGlassContainerGetter();
        cupContainerGetter = new CoffeeCupContainerGetter();
    }

    @Override
    public IContainerSize getGrainContainerDetails(@NotNull EContainerType containerType,
                                                   @NotNull EContainerSize containerSize) {
        return switch (containerType) {
            // In case is a CUP
            case CUP -> this.cupContainerGetter.getDetailsOf(containerSize);

            // In case is a GLASS
            case GLASS -> this.glassContainerGetter.getDetailsOf(containerSize);
        };
    }
}
