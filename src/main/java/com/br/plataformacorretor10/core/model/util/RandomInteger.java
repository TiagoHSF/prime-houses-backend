package com.br.plataformacorretor10.core.model.util;

import java.util.Random;

/**
 * The Class RandomInteger
 *
 * @author Tiago Ferreira.
 * @since 03/11/2023
 */
public class RandomInteger {

    public static Integer randomInteger(Integer min, Integer max){
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}