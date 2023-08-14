package com.cafeteria.exceptions;

public interface IMessages {
    interface Issues {

        /**
         * Has parameters.
         *
         * @apiNote Parameterized string name the name of the complement.
         */
        String ANY_STOCK_OF = "The machine does not contain stock of %s.";

        /**
         * Has parameters.
         *
         * @apiNote Parameterized string name the name of the complement.
         */
        String NOT_ENOUGH_STOCK = "The amount of %s is not enough to make the expected drink.";
    }

    interface INoDone {
        static String getUnableToCleanMachine(Class<?> c) {
            return "The machine was unable to clean the %s stock.".formatted(c.getSimpleName());
        }

    }
}
