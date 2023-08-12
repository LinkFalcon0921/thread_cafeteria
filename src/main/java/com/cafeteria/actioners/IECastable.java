package com.cafeteria.actioners;

import java.util.function.Function;

public interface IECastable<E extends IECastable<E>> extends Function<IECastable<E>, E> {

}
