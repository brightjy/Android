    package com.tj.day_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private Button btnCE, btnC, btnDel, btnPow;
    private Button[] btn = new Button[10];
    private int[] id = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                        R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    private Button btnAdd, btnSub, btnMul, btnDiv, btnDot, btnEqual;
    private double num1, num2; // 계산값 넣을 변수
    private String tempResult; // 결과값 넣을 변수
    private String op=""; // 연산자의 종류(+,-,*,/) 넣을 변수
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
        }); // btnPow의 이벤트
        btnDot.setOnClickListener(numClickListener);
        for(int i=0; i<id.length; i++){
           btn[i].setOnClickListener(numClickListener);
        } // btn[i]들과 btnDot의 이벤트
        btnAdd.setOnClickListener(opClickListener);
        btnSub.setOnClickListener(opClickListener);
        btnMul.setOnClickListener(opClickListener);
        btnDiv.setOnClickListener(opClickListener); // op 이벤트
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (op){
                    case "" : num1 = num2; break;
                    case "+" : num1 += num2; break;
                    case "-" : num1 -= num2; break;
                    case "*" : num1 *= num2; break;
                    case "/" : num1 /= num2; break;
                }
                tempResult = String.valueOf(num1);
                if(tempResult.indexOf(".0")==tempResult.length()-2){
                    tempResult = tempResult.substring(0,tempResult.length()-2);
                }
                tvResult.setText(tempResult);
                num1 = num2 = 0; op="";
            }
        }); // btnEqual 이벤트
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = num2 = 0; op="";
                tvResult.setText("0");
            }
        }); // btnC 이벤트
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempResult = tvResult.getText().toString();
                int length = tempResult.length();
                if(length>1){
                    tempResult = tempResult.substring(0, length-1);
                }else{
                    tempResult = "0";
                }
                tvResult.setText(tempResult); // 화면에 있는 우측 수 하나 없애기
                num2 = Double.parseDouble(tvResult.getText().toString());
            }
        }); // btnDel 이벤트(그냥 한 글자 지우는 것)
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = 0;
                tvResult.setText("0");
            }
        }); // btnCE 이벤트
    }//onCreat 메소드(이벤트는 반드시 onCreate 안에 선언한다.)
    private View.OnClickListener opClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (op){
                case "" : num1 = num2; break;
                case "+" : num1 += num2; break;
                case "-" : num1 -= num2; break;
                case "*" : num1 *= num2; break;
                case "/" : num1 /= num2; break;
            }
            num2 = 0;
            op = ((Button)v).getText().toString(); // View 는 Button을 상속받는다.
            tempResult = String.valueOf(num1);
            if(tempResult.indexOf(".0")==tempResult.length()-2){
                tempResult = tempResult.substring(0,tempResult.length()-2);
            }
            tvResult.setText(tempResult);
        }
    };
    private View.OnClickListener numClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(num2==0 && !tvResult.getText().toString().equals("0.")){
                tvResult.setText("");
            }
            switch (v.getId()){
                case R.id.btn0: tvResult.append("0"); break;
                case R.id.btn1: tvResult.append("1"); break;
                case R.id.btn2: tvResult.append("2"); break;
                case R.id.btn3: tvResult.append("3"); break;
                case R.id.btn4: tvResult.append("4"); break;
                case R.id.btn5: tvResult.append("5"); break;
                case R.id.btn6: tvResult.append("6"); break;
                case R.id.btn7: tvResult.append("7"); break;
                case R.id.btn8: tvResult.append("8"); break;
                case R.id.btn9: tvResult.append("9"); break;
                case R.id.btnDot:
                    if(tvResult.getText().toString().equals("")){
                        tvResult.setText("0.");
                    }else if(tvResult.getText().toString().indexOf(".")==-1){
                        tvResult.append(".");
                    }else{
                        Toast.makeText(getApplicationContext(), "소수점이 두개 일 수 없음", Toast.LENGTH_LONG).show();
                    }//if
            }//switch
            num2 = Double.parseDouble(tvResult.getText().toString());
            System.out.println("현재 num2 = "+num2);
        }//onClick
    };//numClick변수
}//class
