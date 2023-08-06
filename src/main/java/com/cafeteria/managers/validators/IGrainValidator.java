package com.cafeteria.managers.validators;

import com.cafeteria.grains.IGrains;
import com.cafeteria.containers.EContainerSize;

public interface IGrainValidator {
    boolean isApplicable(EContainerSize s, IGrains g);
}