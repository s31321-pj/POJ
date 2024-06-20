package org.example;

import org.example.models.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TeaService implements DrinkInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public Sizes chooseSize() {
        System.out.println("Wybierz rozmiar S, M lub L");
        try{
            return TeaSizes.valueOf(scanner.nextLine().toUpperCase());
        }catch(IllegalArgumentException e){
            System.out.println("INVALID_SIZE domyslnie wybrano rozmiar M");

        }
        return TeaSizes.M;
    }

    @Override
    public List<Additions> chooseAdditions() {
        System.out.println("Wybierz dodatek z listy np. SUGAR, MILK");
        Arrays.stream(TeaAdditions.values())
                .forEach(addition -> System.out.println("- " + addition));
        try{
            String[] choose = scanner.nextLine().toUpperCase().split(","); //przeksztalcamy tablice zeby wywolac metody
            return Arrays.stream(choose)
                    .map(String::trim)//pozbywamy sie bialych znakow
                    .map(TeaAdditions::valueOf)
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
        finalprice *= haveCode();
        orderService.saveOrder(sizes, additions, finalprice, DrinkType.TEA);
        return finalprice;

    }
    public double haveCode(){
        DiscountService discountService = new DiscountService();
        System.out.println("Czy posiadasz kod zniżkowy? TAK/NIE");
        if(scanner.nextLine().equalsIgnoreCase("TAK")){
            System.out.println("Podaj kod zniżkowy");
            try{
                return discountService.discount(scanner.nextLine());
            }catch(DiscountCodeExpired | DiscountCodeException e){
                System.out.println(e.getMessage());
            }
        }
        return 1;
    }
}
