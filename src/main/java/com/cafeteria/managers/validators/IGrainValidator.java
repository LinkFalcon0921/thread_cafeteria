package com.cafeteria.managers.validators;

import com.cafeteria.grains.IGrain;
import com.cafeteria.containers.EContainerSize;

public interface IGrainValidator {
    boolean isApplicable(EContainerSize s, IGrain g);
}