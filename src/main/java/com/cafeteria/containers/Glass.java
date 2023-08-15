package com.cafeteria.containers;

import com.cafeteria.containers.sizes.coffee.ECoffeeGlassSize;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Glass<ES extends IContainerSize> extends Container<ES> {
    public Glass(EContainerSize size, float maxAmount) {
        super(size, maxAmount);
    }

    public Glass(EContainerSize size, float maxAmount, float actualAmount) {
        super(size, maxAmount, actualAmount);
    }

}
