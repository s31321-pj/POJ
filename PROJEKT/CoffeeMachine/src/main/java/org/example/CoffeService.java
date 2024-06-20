package org.example;

import org.example.models.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


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
        try{
            String[] choose = scanner.nextLine().toUpperCase().split(","); //przeksztalcamy tablice zeby wywolac metody
            return Arrays.stream(choose)
                    .map(String::trim)//pozbywamy sie bialych znakow
                    .map(CoffeeAdditions::valueOf)
                    .collect(Collectors.toList());
        }catch(IllegalArgumentException e){
            System.out.println("INVALID_ADDITION brak dodatku na liście");
            throw e;

        }


    }

    @Override
    public double calculatePrice(Sizes sizes, List<Additions> additions) {
        OrderService orderService = new OrderService();
        double finalprice = sizes.getPrice();
        finalprice += additions.stream()
                .mapToDouble(Additions::getPrice)
                .sum();
        orderService.saveOrder(sizes, additions, finalprice, DrinkType.COFFEE);
        return finalprice;

    }
}
