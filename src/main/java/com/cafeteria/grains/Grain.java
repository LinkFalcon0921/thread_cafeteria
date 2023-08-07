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
    public boolean isTypeOf(@NonNull EGrainsType type) {
        return this.getType().equals(type);
    }
}
