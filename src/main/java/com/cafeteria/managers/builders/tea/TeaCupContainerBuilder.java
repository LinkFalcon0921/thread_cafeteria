package com.cafeteria.managers.builders.tea;

import com.cafeteria.containers.sizes.tea.ETeaCupSize;
import com.cafeteria.containers.tea.TeaCup;
import com.cafeteria.managers.builders.ContainerBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeaCupContainerBuilder extends ContainerBuilder<TeaCup, ETeaCupSize> {

    @NonNull
    public static TeaCupContainerBuilder builder() {
        return new TeaCupContainerBuilder();
    }

    @Override
    public TeaCup prepare() {
        return new TeaCup(this.size, this.maxAmount, this.actualAmount);
    }
}
