package bsu.rfe.java.group9.lab1.Gomerov.varB1;

import java.util.Scanner;
import java.util.Arrays;

public class Lab1
{

    public static void main(String[] args)
    {
        Tea[] breakfast = new Tea[5];
        breakfast[0] = new Tea("чёрный");
        breakfast[1] = new Tea("чёрный");
        breakfast[2] = new Tea("зелёный");
        breakfast[3] = new Tea("чёрный");
        breakfast[4] = new Tea("зелёный");
        sliva[] breakfast1 = new sliva[5];
        breakfast1[0] = new sliva("спелая");
        breakfast1[0].consume();

        int b_num = 0;
        for (int i=0; i < breakfast.length; i++)
        {
            if (breakfast[i].getColor().equals("чёрный")) b_num++;
        }
        System.out.println("В завтраке " + b_num + " чёрного чая и " + (breakfast.length-b_num) + "зелёного чая");
        for (int i=0; i < breakfast.length; i++)
        {
            breakfast[i].consume();
        }
        Scanner in = new Scanner(System.in);
        ;     for (;;)
    {
        System.out.println("Доступны параметры:\n-calories\n-sort\n-exit");
        String parameter = in.nextLine();
        if (parameter.equals("-calories"))
        {
            int sum=0;
            for (int i=0; i < breakfast.length; i++)
            {
                sum+=breakfast[i].calculateCalories();
            }
            System.out.println("В завтраке содержится калорий " + sum + " калорий");
        }
        else if (parameter.equals("-sort"))
        {
            Arrays.sort(breakfast, new TeaComparator());
            for (int i=0; i < breakfast.length; i++)
            {
                System.out.println(breakfast[i].toString());
            }
            System.out.println("Завтрак отсортирован!");
        }
        else if (parameter.equals("-exit"))
        {
            System.out.println("Программа завершина!");
            break;
        }
        else System.out.println("Неизвестный параметр!");
    }
    }
}