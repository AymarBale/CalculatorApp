package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    String t = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        TextView operation = findViewById(R.id.operation);
        final TextView[] result = {findViewById(R.id.result)};
        Button btn1 = findViewById(R.id.imageBtn13);
        Button btn2 = findViewById(R.id.imageBtn14);
        Button btn3 = findViewById(R.id.imageBtn15);
        Button btn4 = findViewById(R.id.imageBtn9);
        Button btn5 = findViewById(R.id.imageBtn10);
        Button btn6 = findViewById(R.id.imageBtn11);
        Button btn7 = findViewById(R.id.imageBtn5);
        Button btn8 = findViewById(R.id.imageBtn6);
        Button btn9 = findViewById(R.id.imageBtn7);
        Button btn0 = findViewById(R.id.imageBtn17);
        Button divBtn = findViewById(R.id.imageBtn4);
        Button MulBtn = findViewById(R.id.imageBtn8);
        Button MinusBtn = findViewById(R.id.imageBtn12);
        Button Plusbtn = findViewById(R.id.imageBtn19);
        Button erase = findViewById(R.id.imageBtn1);
        final Button[] Result = {findViewById(R.id.imageBtn20)};
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumTextView("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumTextView("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumTextView("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumTextView("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumTextView("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumTextView("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumTextView("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumTextView("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumTextView("9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumTextView("0");
            }
        });
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                divide();
            }
        });
        MulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiply();
            }
        });
        MinusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minus();
            }
        });
        Plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add();
            }
        });
        Result[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result[0].setText(Resultat((operation.getText()).toString()));
            }
        });
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.setText("0");
                result[0].setText("0");
            }
        });
        result[0].setText("0");
        operation.setText("0");
    }

    public void AddNumTextView(String s){
        TextView operation = findViewById(R.id.operation);
        operation.setText(operation.getText()+s);
    }

    public  void Add(){
        TextView operation = findViewById(R.id.operation);
        operation.setText(operation.getText()+"+");
    }

    public void minus(){
        TextView operation = findViewById(R.id.operation);
        operation.setText(operation.getText()+"-");
    }

    public void multiply(){
        TextView operation = findViewById(R.id.operation);
        operation.setText(operation.getText()+"*");
    }

    public void divide(){
        TextView operation = findViewById(R.id.operation);
        operation.setText(operation.getText()+"/");
    }

    public String Resultat(String s){
        return Operateur.orderOp(s);
    }
}