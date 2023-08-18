package com.cafeteria.machines.tea;

import com.cafeteria.complements.IComplement;
import com.cafeteria.complements.Sugar;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.sizes.tea.ETeaCupSize;
import com.cafeteria.containers.tea.TeaCup;
import com.cafeteria.grains.tea.Tea;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class TeaMachineTest {

    protected static final int SUGAR_MAX_VALUE = 3;
    private EContainerSize containerSize;

    interface IMessages {
        String MACHINE_IS_NULL = "Machine is null";
        String CUP_IS_NULL = "The machine does not create the cup.";
        String TEA_CUP_MAX_SIZE_IS_DIFFERENT = "The size of the tea cup is different as expected.";
    }

    private static TeaMachine MACHINE;
    private static Random RANDOMIZER;

    @BeforeAll
    static void beforeAll() {
        MACHINE = new TeaMachine();
        RANDOMIZER = new Random();
    }

    @Test
    void testCreateSimpleCup() {
        checkMachineNotNull();
        fillMachineStock(60, 50);

        containerSize = EContainerSize.MEDIUM;
        final float sugarAmount = RANDOMIZER.nextFloat(SUGAR_MAX_VALUE);

        Sugar sugar = new Sugar(sugarAmount);

        List<IComplement> complements = List.of(sugar);

        final TeaCup preparedCup = MACHINE.prepareCup(containerSize, complements);

        assertNotNull(preparedCup, IMessages.CUP_IS_NULL);

        assertEquals(preparedCup.getSize().name(), containerSize.name());

        ETeaCupSize teaCupSize = ETeaCupSize.getBySize(containerSize);

        assertEquals(preparedCup.getMaxAmount(), teaCupSize.getMaxContent(),
                IMessages.TEA_CUP_MAX_SIZE_IS_DIFFERENT);
    }

    void fillMachineStock(int teaLeaves, float complementAmount) {
        int teaLeavesTotal = RANDOMIZER.nextInt(teaLeaves) + teaLeaves;

        float complementAmountTotal = RANDOMIZER.nextFloat(complementAmount) + complementAmount;

        Tea tea = new Tea(teaLeavesTotal);
        MACHINE.fillGrainStock(tea);

        List<IComplement> complements = List.of(new Sugar(complementAmountTotal));
        MACHINE.fillComplementStock(complements);

    }

    void checkMachineNotNull() {
        assumeFalse(Objects.isNull(MACHINE), IMessages.MACHINE_IS_NULL);
    }
}