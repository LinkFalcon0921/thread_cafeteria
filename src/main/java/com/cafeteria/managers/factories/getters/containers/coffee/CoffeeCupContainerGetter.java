package com.cafeteria.managers.factories.getters.containers.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.sizes.coffee.ECoffeeCupSize;
import com.cafeteria.managers.factories.getters.containers.IContainerGetter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CoffeeCupContainerGetter implements IContainerGetter<ECoffeeCupSize> {
    @Override
    public ECoffeeCupSize getDetailsOf(EContainerSize containerSize) {
        return ECoffeeCupSize.getBySize(containerSize);
    }

    public static void main(String[] args) {
        System.out.println(IContainerGetter.class.isAssignableFrom(CoffeeCupContainerGetter.class));
    }
}
