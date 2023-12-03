package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /**
         * В рамках выполнения задачи необходимо: Создать свой Java Maven проект;
         * Добавьте зависимость commons-math3 (предназначена для решения математических задач)
         * и изучить интерфейс библиотеки.
         * Воспользоваться пакетом org.apache.commons.math3.stat и классом DescriptiveStatistics.
         * Создать коллекцию из числовых элементов.
         * С помощью объекта DescriptiveStatistics вычислить минимальное и максимальное значение,
         * сумму и среднее арифметическое.
         * Воспользоваться пакетом org.apache.commons.math3.util.
         * С помощью класса ArithmeticUtils найти: факториал числа N.
         * Наименьшее общее частное двух чисел
         * Наибольший общий делитель двух чисел.
         * Проверить что число N это степень двойки
         */
        double[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        DescriptiveStatistics statistics = new DescriptiveStatistics(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Минимальное значение = " + statistics.getMin());
        System.out.println("Максимальное значение = " + statistics.getMax());
        System.out.println("Сумма чисел = " + statistics.getSum());
        System.out.println("Среднее значение = " + statistics.getMean());
        System.out.println("===================================================");
        System.out.println("Факториал 5 = " + ArithmeticUtils.factorial(5)); // не создаем объект класса, так как он приватный
        System.out.println("Наименьшее общее частное двух чисел 15 и 25= " + ArithmeticUtils.lcm(15, 25));
        System.out.println("Наибольший общий делитель двух чисел 15 и 25 = " + ArithmeticUtils.gcd(15, 25));
        System.out.println("Проверить что число 16 это степень двойки = " + ArithmeticUtils.isPowerOfTwo(16));
    }
}