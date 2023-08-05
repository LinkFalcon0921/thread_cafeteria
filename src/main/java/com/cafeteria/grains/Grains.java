package com.cafeteria.grains;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public abstract class Grains implements IGrains{
    protected EGrainsType type;
    protected int amount;
}
