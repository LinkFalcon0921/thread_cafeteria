package com.cafeteria.managers.factories;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.sizes.coffee.ECoffeeCupSize;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CupContainerGetter implements IContainerGetter<ECoffeeCupSize> {
    @Override
    public ECoffeeCupSize getDetailsOf(EContainerSize containerSize) {
        return ECoffeeCupSize.getBySize(containerSize);
    }
}
