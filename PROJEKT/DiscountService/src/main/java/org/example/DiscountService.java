package org.example;

public class DiscountService implements ReduceInterface{

    @Override
    public double discount(String code) throws DiscountCodeException, DiscountCodeExpired{
        CodesList codesList = CodesList.isgood(code);
        if(codesList.getStatus() == 0){
            throw new DiscountCodeExpired("Kod wygasł");
        }
        System.out.println("Kod poprawnie dodany");
        return codesList.getValue();
    }
}
