package com.cafeteria.managers.factories.getters.containers;

import com.cafeteria.exceptions.containers.creators.IssueMachineExceptionCreator;

public abstract class GrainContainerGetterManager implements IGrainContainerGetterManager {
    protected final IssueMachineExceptionCreator EXCEPTION_CREATOR;

    public GrainContainerGetterManager() {
        this.EXCEPTION_CREATOR = IssueMachineExceptionCreator.getCreator();
    }
}
