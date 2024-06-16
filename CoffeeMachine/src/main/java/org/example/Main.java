package org.example;

import org.example.models.DrinkType;

import java.util.Scanner;

public class Main {
    private static DrinkInterface drinkInterface;

    public static void main(String[] args) {
        switch(drinkType()) {
            case TEA:
                drinkInterface = new TeaService();
                break;
            case COFFEE:
                drinkInterface = new CoffeService();
                break;
        }
        double price = drinkInterface.order();
        System.out.println("Do zaplaty: " + String.format("%.2f", price));

    }

    public static DrinkType drinkType(){
        System.out.println("Jaki napoj wariacie COFFEE/TEA");
        try{
            return DrinkType.valueOf(new Scanner(System.in).nextLine().toUpperCase());
        }catch(IllegalArgumentException e){
            System.out.println("INVALID_DRINK_TYPE");
            throw e;
        }
    }

}