    package com.tj.day_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private Button btnCE, btnC, btnDel, btnPow;
    private Button[] btn = new Button[10];
    private int[] id = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                        R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    private Button btnAdd, btnSub, btnMul, btnDiv, btnDot, btnEqual;
    private double num1, num2; // 계산값 넣을 변수
    private double result; // 결과값 넣을 변수
    private String op; // 연산자의 종류(+,-,*,/) 넣을 변수
    private boolean power; // 전원 여부
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("박지영");
        tvResult = findViewById(R.id.tvResult);
        btnCE = findViewById(R.id.btnCE);
        btnC = findViewById(R.id.btnC);
        btnDel = findViewById(R.id.btnDel);
        btnPow = findViewById(R.id.btnPow);
        for(int i=0; i<id.length; i++){
            btn[i] = findViewById(id[i]);
        }
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnDot = findViewById(R.id.btnDot);
        btnEqual = findViewById(R.id.btnEqual);

        power = true;
        btnPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(power){
                    power = false;
                    tvResult.setText("");
                }else{
                    power = true;
                    tvResult.setText("0");
                }
                btnCE.setEnabled(power);
                btnC.setEnabled(power);
                btnDel.setEnabled(power);
                btnAdd.setEnabled(power);
                btnSub.setEnabled(power);
                btnMul.setEnabled(power);
                btnDiv.setEnabled(power);
                btnDot.setEnabled(power);
                btnEqual.setEnabled(power);
                for(int i=0; i<id.length; i++){
                    btn[i].setEnabled(power);
                }
                num1=0; num2=0; op="";
            }
        });


    }
}
