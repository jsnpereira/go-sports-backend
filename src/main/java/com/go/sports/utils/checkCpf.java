package com.go.sports.utils;

import java.util.InputMismatchException;

public class checkCpf {

    public static boolean isCPF(String CPF){
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);

        char type10, type11;
        int sm, i, r, num, weight;

        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            weight = 10;
            for (i=0; i<9; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * weight);
                weight = weight - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                type10 = '0';
            else type10 = (char)(r + 48);

            sm = 0;
            weight = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * weight);
                weight = weight - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                type11 = '0';
            else type11 = (char)(r + 48);

            if ((type10 == CPF.charAt(9)) && (type11 == CPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException error) {
            return(false);
        }
    }

}
