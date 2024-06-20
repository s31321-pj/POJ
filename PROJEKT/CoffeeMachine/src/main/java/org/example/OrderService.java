package org.example;

import org.example.models.Additions;
import org.example.models.DrinkType;
import org.example.models.Sizes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class OrderService {
    public void saveOrder(Sizes sizes, List<Additions> additions, double finalprice, DrinkType drinkType) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("orders.txt", true))){

            printWriter.printf("Drink: %s , Size: %s, Additions: %s, Price: %.2f\n",
                    drinkType, sizes, additions, finalprice);

        } catch (IOException e) {
            System.out.println("Wystąpił błąd, skontaktuj się z obsługą.");

        }
    }
}
