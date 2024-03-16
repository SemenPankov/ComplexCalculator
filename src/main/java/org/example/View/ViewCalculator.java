package org.example.View;

import org.example.Interface.iCalculable;

import java.util.Scanner;

/**
 * Класс {@code ViewCalculator} представляет собой простое текстовое пользовательское
 * интерфейсное взаимодействие с калькулятором, реализующим интерфейс {@code iCalculable}.
 */
public class ViewCalculator {
    private final iCalculable calculator;

    /**
     * Конструктор класса {@code ViewCalculator} с заданным калькулятором.
     *
     * @param calculator Экземпляр калькулятора, реализующего интерфейс {@code iCalculable}.
     */
    public ViewCalculator(iCalculable calculator) {
        this.calculator = calculator;
    }

    /**
     * Запускает пользовательский интерфейс для взаимодействия с калькулятором.
     */
    public void run() {
        while (true) {
            int primaryArg = promptInt("Введите первый аргумент действительного числа: ");
            int secondaryArg = promptInt("Введите первый аргумент мнимого числа: ");
            calculator.complexSum(primaryArg, secondaryArg);
            while (true) {
                String cmd = prompt("Введите команду ('*','+','/', '=') : ");
                if (cmd.equals("*")) {
                    int arg = promptInt("Введите второй аргумент действительного числа: ");
                    int complexArg = promptInt("Введите второй аргумент мнимого числа: ");
                    calculator.complexMulti(arg, complexArg);
                    continue;
                }
                if (cmd.equals("/")) {
                    int arg = promptInt("Введите второй аргумент действительного числа: ");
                    int complexArg = promptInt("Введите второй аргумент мнимого числа: ");
                    calculator.complexDivision(arg, complexArg);
                    continue;
                }
                if (cmd.equals("+")) {
                    int arg = promptInt("Введите второй аргумент действительного числа: ");
                    int complexArg = promptInt("Введите второй аргумент мнимого числа: ");
                    calculator.complexSum(arg, complexArg);
                    continue;
                }
                if (cmd.equals("=")) {
                    System.out.printf("Результат %s\n", calculator.getResult());
                    break;
                }
            }
            String cmd = prompt("Еще посчитать (Y/N)?");
            if (cmd.equalsIgnoreCase("Y")) {
                continue;
            }
            break;
        }
    }

    /**
     * Выводит приглашение для ввода и возвращает введенную строку.
     *
     * @param message Сообщение для пользователя.
     * @return Введенная строка.
     */
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    /**
     * Выводит приглашение для ввода, преобразует введенную строку в целое число и возвращает результат.
     *
     * @param message Сообщение для пользователя.
     * @return Введенное целое число.
     */
    private int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }
}
