package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodesList {
    WINTERTEA("WINTERTEA",0.9, 1),
    GOODCOFFEE("GOODCOFFEE",0.8,1),
    POLSKAGUROM("POLSKAGUROM",0.1,0);

    private final String code;
    private final double value;
    private final int status;

    public static CodesList isgood(String code) throws DiscountCodeException{
        for(CodesList codesList : CodesList.values()) {
            if (codesList.getCode().equals(code)){
                return codesList;
            }
        }
        throw new DiscountCodeException("Błędny kod");
    }


}
