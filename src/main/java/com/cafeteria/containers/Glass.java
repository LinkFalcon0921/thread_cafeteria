package com.cafeteria.containers;

import com.cafeteria.containers.sizes.coffee.ECoffeeGlassSize;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Glass extends Container<ECoffeeGlassSize> {
    public Glass(EContainerSize size, float maxAmount) {
        super(size, maxAmount);
    }

    public Glass(EContainerSize size, float maxAmount, float actualAmount) {
        super(size, maxAmount, actualAmount);
    }

    @Override
    public ECoffeeGlassSize getSize() {
        return ECoffeeGlassSize.getBySize(this.SIZE);
    }
}
