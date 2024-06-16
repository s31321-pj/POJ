package org.example;

import org.example.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CoffeService implements DrinkInterface{
    Scanner scanner = new Scanner(System.in);

    @Override
    public Sizes chooseSize() {
        System.out.println("Wybierz rozmiar S, M lub L");
        try{
            return CoffeeSizes.valueOf(scanner.nextLine().toUpperCase());
        }catch(IllegalArgumentException e){
            System.out.println("INVALID_SIZE domyslnie wybrano rozmiar M");

        }
        return CoffeeSizes.M;
    }

    @Override
    public List<Additions> chooseAdditions() {
        System.out.println("Wybierz dodatek z listy np. SUGAR, MILK");
        Arrays.stream(CoffeeAdditions.values())
                .forEach(addition -> System.out.println("- " + addition));
    }

    @Override
    public double calculatePrice(Sizes sizes, List<Additions> additions) {
        return 0;
    }
}
