package com.company.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {
    private static float x0;
    private static float y0;
    private static float r;

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String values = scanner.nextLine();
        x0 = values.charAt(0);
        y0 = values.charAt(1);
        r = scanner.nextLine().charAt(0);
        try {
            scanner = new Scanner(new File(args[1]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            String values2 = scanner.nextLine();
            int x = Integer.parseInt(values2.substring(0, 1));
            int y = Integer.parseInt(values2.substring(1, 2));
            switch (insideInCircle(x, y)) {
                case 0:
                    System.out.println(x + "" + y + "" + " точка лежит на окружности");
                    break;
                case 1:
                    System.out.println(x + "" + y + "" + " точка внутри");
                    break;
                case 2:
                    System.out.println(x + "" + y + "" + " точка снаружи");
                    break;
            }
        }
    }

    private static int insideInCircle(int x, int y) {
        float result = (x - x0) * (x - x0) + (y - y0) * (y - y0);
        if(result == r * r) {
            return 0;
        } else if (result < r *r) {
            return 1;
        }
        return 2;
    }
}
