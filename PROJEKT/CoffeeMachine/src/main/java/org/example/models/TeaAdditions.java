package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TeaAdditions implements Additions{
    SUGAR(0.5),
    HONEY(2.0),
    RUM(5.0);

    private final double price;
}
