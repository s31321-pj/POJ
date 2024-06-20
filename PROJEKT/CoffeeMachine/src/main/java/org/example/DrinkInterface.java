package org.example;
import org.example.models.Additions;
import org.example.models.Sizes;

import java.util.List;

public interface DrinkInterface {
    default double order() {
        //tu return wszystko zwraca to po co wincyj
        return calculatePrice(chooseSize(), chooseAdditions());
    }
    Sizes chooseSize();
    List<Additions> chooseAdditions();
    double calculatePrice(Sizes sizes, List<Additions> additions);
}
