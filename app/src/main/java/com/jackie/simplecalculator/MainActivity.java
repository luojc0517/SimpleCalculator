package com.jackie.simplecalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnClear;
    private Button btnDel;
    private Button btnDivide;
    private Button btnMutiply;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnMinus;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btnPlus;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btnEquals;
    private Button btn0;
    private Button btnDot;
    private EditText editText;
    private int flag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnMutiply = (Button) findViewById(R.id.btnMutiply);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        btnDot = (Button) findViewById(R.id.btnDot);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnMutiply.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnDot.setOnClickListener(this);

    }

    public void getResult() {
        String exp = editText.getText().toString();
        double result = 0;
        if (exp == null || exp.equals("")) {
            return;
        }
        if (!exp.contains(" ")) {
            return;
        }
        String str1 = exp.substring(0, exp.indexOf(" "));
        String operation = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
        String str2 = exp.substring(exp.indexOf(" ") + 2);
        Log.d("jackie", str1 + "\n");
        Log.d("jackie", operation + "\n");
        Log.d("jackie", str2 + "\n");


        try {
            double d1 = Double.parseDouble(str1);
            double d2 = Double.parseDouble(str2);
            switch (operation) {
                case "+":
                    result = d1 + d2;
                    break;
                case "-":
                    result = d1 - d2;
                    break;
                case "÷":
                    if (d2 != 0) {
                        result = d1 / d2;
                        break;
                    }
                case "×":
                    result = d1 * d2;
                    break;
            }
            editText.setText("" + result);
            flag = 0;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "非法操作！", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onClick(View v) {
        String str = editText.getText().toString();
        switch (v.getId()) {
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
            case R.id.btn0:
            case R.id.btnDot:
                editText.setText(str + ((Button) v).getText());
                break;
            case R.id.btnDivide:
            case R.id.btnMinus:
            case R.id.btnMutiply:
            case R.id.btnPlus:
                if (flag == 0) {
                    editText.setText(str + " " + ((Button) v).getText() + " ");
                    flag++;
                } else {
                    getResult();
                }
                break;
            case R.id.btnEquals:
                getResult();
                break;
            case R.id.btnClear:
                editText.setText("");
                break;
            case R.id.btnDel:
                if (str != null && !str.equals("")) {
                    editText.setText(str.substring(0, str.length() - 1));
                }
                break;

        }
    }
}
