package com.gurpster.kraken;

import android.util.Patterns;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Williaan Souza (dextter) on 25/10/2020
 * Contact williaanlopes@gmail.com
 */
public class ValidatorUtils {

    // CPF
    private static final int[] WEIGHT_SSN = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    // CNPJ
    private static final int[] WEIGHT_TIN = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calculate(final String str, final int[] weight) {
        int sum = 0;
        for (int i = str.length() - 1, digit; i >= 0; i--) {
            digit = Integer.parseInt(str.substring(i, i + 1));
            sum += digit * weight[weight.length - str.length() + i];
        }
        sum = 11 - sum % 11;
        return sum > 9 ? 0 : sum;
    }

    /**
     * Valida CPF
     *
     * @param cpf
     * @return boolean
     */
    public static boolean isValidCpf(String cpf) {
        cpf = StringUtils.onlyNumbers(cpf);
        if ((cpf == null) || (cpf.length() != 11) || cpf.matches(cpf.charAt(0) + "{11}"))
            return false;

        final int digit1 = calculate(cpf.substring(0, 9), WEIGHT_SSN);
        final int digit2 = calculate(cpf.substring(0, 9) + digit1, WEIGHT_TIN);
        return cpf.equals(cpf.substring(0, 9) + digit1 + digit2);
    }

    /**
     * Valida CNPJ
     *
     * @param cnpj
     * @return
     */
    public static boolean isValidCnpj(final String cnpj) {
        if ((cnpj == null) || (cnpj.length() != 14) || cnpj.matches(cnpj.charAt(0) + "{14}"))
            return false;

        final int digit1 = calculate(cnpj.substring(0, 12), WEIGHT_TIN);
        final int digit2 = calculate(cnpj.substring(0, 12) + digit1, WEIGHT_SSN);
        return cnpj.equals(cnpj.substring(0, 12) + digit1 + digit2);
    }

    public static boolean isValidPhoneNumber(@NotNull final String phone) {
        return (phone.length() == 11);
    }

    public static boolean isValidUrl(@NonNull String url) {
        return Patterns.WEB_URL.matcher(url).matches();
    }

    public static boolean isValidEmail(@NonNull String url) {
        return Patterns.EMAIL_ADDRESS.matcher(url).matches();
    }

    public static boolean isValidIP(@NonNull String url) {
        return Patterns.IP_ADDRESS.matcher(url).matches();
    }
}
