package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TeaSizes implements Sizes{
    S(2.5),
    M(4.5),
    L(6);

    private final double price;
}
