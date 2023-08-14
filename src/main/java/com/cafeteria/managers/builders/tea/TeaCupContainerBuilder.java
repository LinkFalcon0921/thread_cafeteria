package com.cafeteria.managers.builders.tea;

import com.cafeteria.containers.sizes.tea.ETeaCupSize;
import com.cafeteria.containers.tea.TeaCup;
import com.cafeteria.grains.tea.Tea;
import com.cafeteria.managers.builders.ContainerBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeaCupContainerBuilder implements ContainerBuilder<TeaCup, ETeaCupSize> {
    @Override
    public Tea prepare() {
        return null;
    }
}
