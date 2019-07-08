package com.example.amlakdb_test.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.util.StringTokenizer;

public class NumberTextWatcherForThousand implements TextWatcher {
    EditText editText;

    public NumberTextWatcherForThousand(EditText editText2) {
        this.editText = editText2;
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void afterTextChanged(Editable s) {
        try {
            this.editText.removeTextChangedListener(this);
            String value = this.editText.getText().toString();
            if (value != null && !value.equals("")) {
                if (value.startsWith(".")) {
                    this.editText.setText("0.");
                }
                if (value.startsWith("0") && !value.startsWith("0.")) {
                    this.editText.setText("");
                }
                String str = this.editText.getText().toString().replaceAll(",", "");
                if (!value.equals("")) {
                    this.editText.setText(getDecimalFormattedString(str));
                }
                this.editText.setSelection(this.editText.getText().toString().length());
            }
            this.editText.addTextChangedListener(this);
        } catch (Exception ex) {
            ex.printStackTrace();
            this.editText.addTextChangedListener(this);
        }
    }

    public static String getDecimalFormattedString(String value) {
        StringTokenizer lst = new StringTokenizer(value, ".");
        String str1 = value;
        String str2 = "";
        if (lst.countTokens() > 1) {
            str1 = lst.nextToken();
            str2 = lst.nextToken();
        }
        String str3 = "";
        int i = 0;
        int j = str1.length() - 1;
        if (str1.charAt(str1.length() - 1) == '.') {
            j--;
            str3 = ".";
        }
        for (int k = j; k >= 0; k--) {
            if (i == 3) {
                StringBuilder sb = new StringBuilder();
                sb.append(",");
                sb.append(str3);
                str3 = sb.toString();
                i = 0;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str1.charAt(k));
            sb2.append(str3);
            str3 = sb2.toString();
            i++;
        }
        if (str2.length() <= 0) {
            return str3;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str3);
        sb3.append(".");
        sb3.append(str2);
        return sb3.toString();
    }

    public static String trimCommaOfString(String string) {
        if (string.contains(",")) {
            return string.replace(",", "");
        }
        return string;
    }
}
