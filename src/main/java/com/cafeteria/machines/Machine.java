package com.cafeteria.machines;

import com.cafeteria.complements.IComplement;
import com.cafeteria.exceptions.stocks.UndoneException;
import com.cafeteria.grains.IGrain;
import com.cafeteria.machines.stocks.StockMachine;

import java.util.List;

public class Machine implements IMachine {
    protected final StockMachine stocks;

    public Machine() {
        stocks = new StockMachine();
    }

    @Override
    public boolean fillGrainStock(IGrain g) {
        return this.stocks.addStock(g);
    }

    @Override
    public boolean fillComponentStock(IComplement c) {
        return this.stocks.addStock(c);
    }

    @Override
    public boolean fillGrainStock(List<IGrain> gList) {
        return gList.stream().allMatch(this::fillGrainStock);
    }

    @Override
    public boolean fillComponentStock(List<IComplement> cList) {
        return cList.stream().allMatch(this::fillComponentStock);
    }

    @Override
    public void restart() throws UndoneException {
        this.stocks.cleanStocks();
    }

}
