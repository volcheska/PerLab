package com.company.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        int k = 0;
        List<Integer> values = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scanner.hasNextInt()){
            values.add(scanner.nextInt());
        }
        int avrg = (int)values.stream().mapToDouble(d -> d).average().orElse(0.0);
        for(int i = 0; i < values.size(); i++) {
            while(avrg!=values.get(i)) {
                if(values.get(i) > avrg) {
                    values.set(i,values.get(i) - 1);
                    k++;
                } else {
                    values.set(i, values.get(i) + 1);
                    k++;
                }
            }
        }
        System.out.println(k);
    }

}
