package org.example;


public class DiscountCodeExpired extends RuntimeException {
    public DiscountCodeExpired(String message){
        super(message);
    }
}
