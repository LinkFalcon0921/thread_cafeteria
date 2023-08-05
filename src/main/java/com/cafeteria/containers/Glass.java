package com.cafeteria.containers;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Glass implements IContainer{
    @Setter(AccessLevel.NONE)
    private final ESizeContainer size;
    private float amount;

    @Override
    public String getSize() {
        return String.format("%s%s", this.amount, this.size);
    }
}
