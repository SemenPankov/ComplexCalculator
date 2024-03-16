package org.example.Model;

import org.example.Interface.iCalculable;

/**
 * Класс {@code Decorator} реализует интерфейс {@code iCalculable} и представляет собой декоратор для класса {@code Calculator}.
 * Декоратор добавляет функциональность логирования к операциям над комплексными числами.
 */
public class Decorator implements iCalculable {
    /**
     * Экземпляр оригинального калькулятора.
     */
    private final Calculator oldCalculator;


    /**
     * Экземпляр логгера для записи событий.
     */
    private final Logger logger;

    /**
     * Конструктор класса {@code Decorator} с оригинальным калькулятором и логгером.
     *
     * @param oldCalculator Оригинальный калькулятор.
     * @param logger        Логгер для записи событий.
     */
    public Decorator(Calculator oldCalculator, Logger logger) {
        this.oldCalculator = oldCalculator;
        this.logger = logger;
    }

    /**
     * Складывает указанные действительную и мнимую части с комплексным числом, логируя события.
     *
     * @param arg        Действительная часть для сложения.
     * @param complexArg Мнимая часть для сложения.
     * @return Модифицированное комплексное число.
     */
    @Override
    public iCalculable complexSum(int arg, int complexArg) {
        String firstArg = oldCalculator.getResult();
        String secondArg = oldCalculator.complexResult(arg, complexArg);
        logger.log(String.format("LOG: Начало вызова метода complexSum с параметром %s", firstArg, secondArg));
        iCalculable result = oldCalculator.complexSum(arg, complexArg);
        logger.log(String.format("LOG:Вызова метода complexSum произошел"));
        return result;
    }

    /**
     * Умножает комплексное число на указанные действительную и мнимую части, логируя события.
     *
     * @param arg        Действительная часть для умножения.
     * @param complexArg Мнимая часть для умножения.
     * @return Модифицированное комплексное число.
     */
    @Override
    public iCalculable complexMulti(int arg, int complexArg) {
        String firstArg = oldCalculator.getResult();
        String secondArg = oldCalculator.complexResult(arg, complexArg);
        logger.log(String.format("LOG:  Начало вызова метода complexMulti с параметром %s", firstArg, secondArg));
        iCalculable result = oldCalculator.complexMulti(arg, complexArg);
        logger.log(String.format("LOG:Вызова метода complexMulti произошел"));
        return result;
    }

    /**
     * Делит комплексное число на указанные действительную и мнимую части, логируя события.
     *
     * @param arg        Действительная часть для деления.
     * @param complexArg Мнимая часть для деления.
     * @return Модифицированное комплексное число.
     */
    @Override
    public iCalculable complexDivision(int arg, int complexArg) {
        String firstArg = oldCalculator.getResult();
        String secondArg = oldCalculator.complexResult(arg, complexArg);
        logger.log(String.format("LOG: Начало вызова метода complexDivision с параметром %s", firstArg, secondArg));
        iCalculable result = oldCalculator.complexDivision(arg, complexArg);
        logger.log(String.format("LOG:Вызова метода complexDivision произошел"));

        return result;
    }

    /**
     * Возвращает действительную часть комплексного числа, логируя событие.
     *
     * @return Действительная часть комплексного числа.
     */
    @Override
    public int getRealPart() {
        int arg = oldCalculator.getRealPart();
        logger.log(String.format("LOG:Получение аргумент действительно числа %d", arg));
        return arg;
    }

    /**
     * Возвращает мнимую часть комплексного числа, логируя событие.
     *
     * @return Мнимая часть комплексного числа.
     */
    @Override
    public int getImaginaryPart() {
        int arg = oldCalculator.getImaginaryPart();
        logger.log(String.format("LOG:Получение аргумент мнимого числа %di", arg));
        return arg;
    }

    /**
     * Возвращает результат в виде строки, представляющей комплексное число, логируя событие.
     *
     * @return Строковое представление комплексного числа.
     */
    @Override
    public String getResult() {
        String result = oldCalculator.getResult();
        logger.log(String.format("LOG: Получение результата %s", result));
        return result;
    }
}
