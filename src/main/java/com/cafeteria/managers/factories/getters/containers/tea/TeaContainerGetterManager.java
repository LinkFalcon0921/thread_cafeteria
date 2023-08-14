package com.cafeteria.managers.factories.getters.containers.tea;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.IContainerSize;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.managers.factories.getters.containers.GrainContainerGetterManager;
import org.jetbrains.annotations.NotNull;

public class TeaContainerGetterManager extends GrainContainerGetterManager {
    private final TeaCupContainerGetter cupContainerGetter;

    public TeaContainerGetterManager() {
        super();
        cupContainerGetter = new TeaCupContainerGetter();
    }

    @Override
    public IContainerSize getGrainContainerDetails(@NotNull EContainerType containerType,
                                                   @NotNull EContainerSize containerSize)
            throws IssueMachineException {

        return switch (containerType) {
            // In case is a CUP
            case CUP -> this.cupContainerGetter.getDetailsOf(containerSize);

            default -> throw EXCEPTION_CREATOR.createUnsupportedContainerSizeException();
        };
    }
}
