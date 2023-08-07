package com.cafeteria.managers.factories;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.sizes.coffee.ECoffeeCupSize;
import com.cafeteria.containers.sizes.coffee.ECoffeeGlassSize;

public class CoffeeContainerGetterManager {
    private final GlassContainerGetter glassContainerGetter;
    private final CupContainerGetter cupContainerGetter;

    public CoffeeContainerGetterManager() {
        glassContainerGetter = new GlassContainerGetter();
        cupContainerGetter = new CupContainerGetter();
    }

    public ECoffeeCupSize getCoffeeCupDetails(EContainerSize size){
        return this.cupContainerGetter.getDetailsOf(size);
    }
    public ECoffeeGlassSize getCoffeeGlassDetails(EContainerSize size){
        return this.glassContainerGetter.getDetailsOf(size);
    }
}
