package com.cafeteria.grains;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public abstract class Grain implements IGrain {
    protected EGrainsType type;
    protected int amount;

    @Override
    public void fill(Integer amount) {
        this.amount += amount;
    }

    @Override
    public Integer withdraw(Integer amount) {
        if(this.amount <= amount){
            this.amount -= amount;
            return amount;
        }

        return 0;
    }

    @Override
    public boolean isTypeOf(@NonNull EGrainsType type) {
        return this.getType().equals(type);
    }
}
