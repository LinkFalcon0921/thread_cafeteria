package com.cafeteria.managers.builders.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.coffee.CoffeeCup;
import com.cafeteria.containers.sizes.coffee.ECoffeeCupSize;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoffeeCupContainerBuilder implements IContainerBuilder<CoffeeCup, ECoffeeCupSize> {
    private EContainerSize size;
    private float actualAmount;
    private float maxAmount;

    @NonNull
    public static CoffeeCupContainerBuilder builder() {
        return new CoffeeCupContainerBuilder();
    }

    public CoffeeCup prepare() {
        return new CoffeeCup(this.size, this.actualAmount, this.maxAmount);
    }

    public CoffeeCupContainerBuilder setSize(EContainerSize size) {
        this.size = size;
        return this;
    }

    public CoffeeCupContainerBuilder setActualAmount(float actualAmount) {
        this.actualAmount = actualAmount;
        return this;

    }

    public CoffeeCupContainerBuilder setMaxAmount(float maxAmount) {
        this.maxAmount = maxAmount;
        return this;
    }
}
