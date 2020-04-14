package com.tj.day_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edit1, edit2;
    private Button[] btnNum = new Button[10];
    private int[] id = {R.id.btnNum0,R.id.btnNum1,R.id.btnNum2,R.id.btnNum3,R.id.btnNum4,
                        R.id.btnNum5,R.id.btnNum6,R.id.btnNum7,R.id.btnNum8,R.id.btnNum9};
    private Button btnAdd, btnSub, btnMul, btnDiv;
    private ImageView image1, image2;
    private TextView textResult;
    private String num1="0", num2="0"; // 계산 중 저장해 놓을 값
    private int result; // 계산 결과를 담는 변수
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        for(int i=0; i<id.length; i++){
            btnNum[i] = findViewById(id[i]);
        }
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        textResult = findViewById(R.id.textResult);

        for(int i=0; i<id.length; i++){
            final int idx=i;
            btnNum[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edit1.isFocused()){
                        num1 = edit1.getText().toString() + idx;
                        edit1.setText(num1);
                    }else if(edit2.isFocused()){
                        num2 = edit2.getText().toString() + idx;
                        edit2.setText(num2);
                    }else{
                        Toast.makeText(getApplicationContext(), "에디터를 선택하세요.", Toast.LENGTH_SHORT);
                    }
                }
            });
        }//for
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1)+Integer.parseInt(num2);
                if(result>1000){
                    image1.setVisibility(View.VISIBLE);
                    image2.setVisibility(View.INVISIBLE);
                }else{
                    image1.setVisibility(View.INVISIBLE);
                    image2.setVisibility(View.VISIBLE);
                }
                textResult.setText("계산결과 = "+result);
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1)-Integer.parseInt(num2);
                if(result>1000){
                    image1.setVisibility(View.VISIBLE);
                    image2.setVisibility(View.INVISIBLE);
                }else{
                    image1.setVisibility(View.INVISIBLE);
                    image2.setVisibility(View.VISIBLE);
                }
                textResult.setText("계산결과 = "+result);
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1)*Integer.parseInt(num2);
                if(result>1000){
                    image1.setVisibility(View.VISIBLE);
                    image2.setVisibility(View.INVISIBLE);
                }else{
                    image1.setVisibility(View.INVISIBLE);
                    image2.setVisibility(View.VISIBLE);
                }
                textResult.setText("계산결과 = "+result);
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1)/Integer.parseInt(num2);
                if(result>1000){
                    image1.setVisibility(View.VISIBLE);
                    image2.setVisibility(View.INVISIBLE);
                }else{
                    image1.setVisibility(View.INVISIBLE);
                    image2.setVisibility(View.VISIBLE);
                }
                textResult.setText("계산결과 = "+result);
            }
        });
    }//onCreate
}//class
