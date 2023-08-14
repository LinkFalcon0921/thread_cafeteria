package com.cafeteria.managers.builders.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.coffee.CoffeeCup;
import com.cafeteria.containers.sizes.coffee.ECoffeeCupSize;
import com.cafeteria.managers.builders.ContainerBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoffeeCupContainerBuilder extends ContainerBuilder<CoffeeCup, ECoffeeCupSize> {
    @NonNull
    public static CoffeeCupContainerBuilder builder() {
        return new CoffeeCupContainerBuilder();
    }

    public CoffeeCup prepare() {
        return new CoffeeCup(this.size, this.actualAmount, this.maxAmount);
    }


}
