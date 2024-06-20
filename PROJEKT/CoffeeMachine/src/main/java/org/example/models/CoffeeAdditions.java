package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CoffeeAdditions implements Additions{
    SUGAR(0.5),
    MILK(2.0),
    ALCOHOL(6.0);

    private final double price;
}
