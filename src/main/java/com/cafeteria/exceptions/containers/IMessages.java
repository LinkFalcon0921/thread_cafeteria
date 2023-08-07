package com.cafeteria.exceptions.containers;

public interface IMessages {
     interface Issues {

         String NOT_ENOUGH_GRAINS = "The amount of grains is not enough to make the expected drink.";
         /**Has parameters.
          * @apiNote Parameterized string name the name of the complement*/
         String NOT_ENOUGH_COMPLEMENT = "The amount of grains is not enough to make the expected drink.";

     }
}
