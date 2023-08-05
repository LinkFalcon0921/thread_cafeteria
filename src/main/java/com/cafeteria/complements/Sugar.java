package com.cafeteria.complements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Sugar {
    private float amount;
    private final EPortion portion;
}
