package com.example;

import java.util.List;

public class DataForTesting {
    //Basic
    public static final Integer ZERO = 0;
    public static final Integer ONE_MORE_ZERO = 1;
    public static final Integer ONE_LESS_ZERO = -1;
    public static final Integer VAR_FOR_MATH = 10;

    //Animal types
    public static final String PREDATOR = "Хищник";
    public static final String HERBIVORE = "Травоядное";
    public static final String OMNIVORE = "Всеядное";
    //Sex
    public static final String MAN = "Самец";
    public static final String WOMAN = "Самка";
    public static final String PERVERT = "Нечто";
    //Feed
    public static final List<String> PREDATOR_FOOD = List.of("Животные", "Птицы", "Рыба");
    public static final List<String> HERBIVORE_FOOD = List.of("Трава", "Различные растения");
    public static final List<String> OMNIVORE_FOOD = List.of("Животные", "Птицы", "Рыба", "Трава", "Различные растения");
    public static final String INEDIBLE_FOOD = "Неподходящая еда";
    //Sound
    public static final String CAT_SOUND = "Мяу";
    //Exemption messages
    public static final String EXCEPTION_MESSAGE = "Expected Exception";
    public static final String EXPAT_UNKNOWN_TYPE = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    public static final String EXPAT_UNKNOWN_MANE = "Используйте допустимые значения пола животного - Самец или Самка";
    //Other variables
    public static final String FAMILY = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    public static final String FELINE_FAMILY = "Кошачьи";
    //поля для заполнения:
    //Пол, Соответствие мужскому, Тип животного, Еда, Количество вызовов метода,
    // Ожидаемое колличество вызовов метода, Количество раз вызова метода
    public static final Object[][] FELINE_TEST = {
            {1, 1, -1},
            {1, 1, 0},
            {1, 1, 1},
            {2, 0, 2},
            {-5, -5, 2},
            {-1, -1, 2},
            {0, 0, 2},
            {1, 1, 2},
            {2, 2, 2},
            {3, 3, 3},
    };
    public static final Object[][] FELINE_NEGATIVE_TEST = {
            {1, 1, -5},
            {1, 1, -1},
            {2, 0, 2},
    };
    public static final Object[][] LION_TOLERABLE_SEX = {
            {MAN, true, PREDATOR, PREDATOR_FOOD, 1, 1, 1},
            {WOMAN, false, PREDATOR, PREDATOR_FOOD, 2, 2, 2},
            {MAN, true, PREDATOR, PREDATOR_FOOD, 3, 3, 3},
            {WOMAN, false, PREDATOR, PREDATOR_FOOD, 4, 4, 4},
            {WOMAN, false, PREDATOR, PREDATOR_FOOD, 7, 7, 7},
            {WOMAN, false, PREDATOR, PREDATOR_FOOD, 8, 8, 8},
            {MAN, true, PREDATOR, HERBIVORE_FOOD, 1, 1, 1},
            {WOMAN, true, PREDATOR, PREDATOR_FOOD, 6, 6, 6},
    };
    public static final Object[][] LION_NEGATIVE_SEX = {
            {PERVERT, true, PREDATOR, PREDATOR_FOOD, 5, 5, 5},
    };

}
