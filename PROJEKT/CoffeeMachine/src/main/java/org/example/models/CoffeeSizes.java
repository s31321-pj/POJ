package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CoffeeSizes implements Sizes{
    S(5),
    M(7),
    L(9);

    private final double price;
}
