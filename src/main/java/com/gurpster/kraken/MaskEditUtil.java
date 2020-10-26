package com.gurpster.kraken;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public abstract class MaskEditUtil {

    public static final String FORMAT_CPF = "###.###.###-##";
    public static final String FORMAT_FONE = Resources.getSystem().getString(R.string.format_phone);//"## ####-#####";
    public static final String FORMAT_MOBILE_PHONE = Resources.getSystem().getString(R.string.format_mobile_phone);//"## # ####-####";
    public static final String FORMAT_CEP = Resources.getSystem().getString(R.string.format_date);//"#####-###";
    public static final String FORMAT_DATE = Resources.getSystem().getString(R.string.format_date); //"##/##/####";
    public static final String FORMAT_HOUR = Resources.getSystem().getString(R.string.format_hour);//"##:##";

    public static TextWatcher mask(EditText ediTxt, int mask) {
        return mask(ediTxt, "");
    }

    /**
     * Metodo que deve ser chamado para realizar a formatacao
     *
     * @param editText input
     * @param mask custom mask
     * @return TextWatcher masked text
     */
    public static TextWatcher mask(final EditText editText, final String mask) {
        return new TextWatcher() {
            boolean isUpdating;
            String old = "";

            @Override
            public void afterTextChanged(final Editable s) {
            }

            @Override
            public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) {
            }

            @Override
            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {
                final String str = MaskEditUtil.unmask(s.toString());
                String mascara = "";
                if (isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (final char m : mask.toCharArray()) {
                    if (m != '#' && str.length() > old.length()) {
                        mascara += m;
                        continue;
                    }
                    try {
                        mascara += str.charAt(i);
                    } catch (final Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                editText.setText(mascara);
                editText.setSelection(mascara.length());
            }
        };
    }

    public static String unmask(final String s) {
        return s.replaceAll("[.]", "")
                .replaceAll("[-]", "")
                .replaceAll("[/]", "")
                .replaceAll("[(]", "")
                .replaceAll("[ ]", "")
                .replaceAll("[:]", "")
                .replaceAll("[)]", "");
    }
}