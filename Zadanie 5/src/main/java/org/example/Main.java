package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Costam");
        list.add("Innecos");
        list.add("Jeszcze Inne Cos");

        boolean costam = list.remove("Costam");

        Set<String> collect = list
                .stream()
                .map(e -> e.toUpperCase(Locale.ROOT))
                .collect(Collectors.toSet());

        System.out.println(list);
        System.out.println(collect);
    }
}