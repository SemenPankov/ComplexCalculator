package org.example.Model;

import org.example.Interface.iCalculable;

/**
 * Класс {@code Calculator} реализует интерфейс {@code iCalculable} и предоставляет основные операции для работы
 * с комплексными числами.
 */
public final class Calculator implements iCalculable {
    /**
     * Действительная часть комплексного числа.
     */
    private int realPart;

    /**
     * Мнимая часть комплексного числа.
     */
    private int imaginaryPart;

    /**
     * Конструктор класса {@code Calculator} с заданными действительной и мнимой частями.
     *
     * @param realPart      Действительная часть комплексного числа.
     * @param imaginaryPart Мнимая часть комплексного числа.
     */
    public Calculator(int realPart, int imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Складывает указанные действительную и мнимую части с комплексным числом.
     *
     * @param real      Действительная часть для сложения.
     * @param imaginary Мнимая часть для сложения.
     * @return Модифицированное комплексное число.
     */
    @Override
    public iCalculable complexSum(int real, int imaginary) {
        realPart += real;
        imaginaryPart += imaginary;
        return this;
    }

    /**
     * Умножает комплексное число на указанные действительную и мнимую части.
     *
     * @param real      Действительная часть для умножения.
     * @param imaginary Мнимая часть для умножения.
     * @return Модифицированное комплексное число.
     */
    @Override
    public iCalculable complexMulti(int real, int imaginary) {
        var tmpPrimaryArg = realPart * real - imaginaryPart * imaginary;
        var tmpSecondaryArg = realPart * imaginary + imaginaryPart * real;
        realPart = tmpPrimaryArg;
        imaginaryPart = tmpSecondaryArg;
        return this;
    }

    /**
     * Делит комплексное число на указанные действительную и мнимую части.
     *
     * @param real      Действительная часть для деления.
     * @param imaginary Мнимая часть для деления.
     * @return Модифицированное комплексное число.
     */
    @Override
    public iCalculable complexDivision(int real, int imaginary) {
        var divider = Math.pow(real, 2) + Math.pow(imaginary, 2);

        if (divider != 0) {
            if (imaginary < 0) {
                divider -= 2 * Math.pow(imaginary, 2);
            }

            this.complexMulti(real, imaginary * (-1));
            realPart /= (int) divider;
            imaginaryPart /= (int) divider;
        } else {
            System.out.println("Деление на ноль не определено.");
        }
        return this;
    }

    /**
     * Возвращает действительную часть комплексного числа.
     *
     * @return Действительная часть комплексного числа.
     */
    @Override
    public int getRealPart() {
        return realPart;
    }

    /**
     * Возвращает мнимую часть комплексного числа.
     *
     * @return Мнимая часть комплексного числа.
     */
    @Override
    public int getImaginaryPart() {
        return imaginaryPart;
    }

    /**
     * Возвращает результат в виде строки, представляющей комплексное число.
     *
     * @return Строковое представление комплексного числа.
     */
    @Override
    public String getResult() {
        String answer = String.valueOf(realPart);
        if (imaginaryPart >= 0) {
            answer += "+";
        }
        answer += imaginaryPart + "i";
        return answer;
    }

    /**
     * Возвращает результат в виде строки для указанных действительной и мнимой частей.
     *
     * @param firstArg  Действительная часть.
     * @param secondArg Мнимая часть.
     * @return Строковое представление комплексного числа.
     */
    public String complexResult(int firstArg, int secondArg) {
        String answer = String.valueOf(firstArg);
        if (secondArg >= 0) {
            answer += "+";
        }
        answer += secondArg + "i";
        return answer;
    }
}
