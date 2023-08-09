package com.cafeteria.exceptions;

public interface IMessages {
     interface Issues {

         String NOT_ENOUGH_GRAINS = "The amount of grains is not enough to make the expected drink.";
         /**Has parameters.
          * @apiNote Parameterized string name the name of the complement*/
         String NOT_ENOUGH_COMPLEMENT = "The amount of grains is not enough to make the expected drink.";

     }

     interface INoDone{
         String MACHINE_UNABLE_CLEAN = "The machine was unable to clean.";

     }
}
