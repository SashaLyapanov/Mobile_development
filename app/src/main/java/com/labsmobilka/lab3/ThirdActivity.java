package com.labsmobilka.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{
    Button mButton0, mButton1, mButton2, mButton3, mButton4, mButton5,
            mButton6, mButton7, mButton8, mButton9, mButtonPoint, mButtonAdd,
            mButtonSub, mButtonDiv, mButtonMul, mButtonEq, mButtonSqrt, mButtonM, mButtonMC, mButton2Deg;
    EditText mEditText;
    float mValueOne, mValueTwo;
    float mValueThree = 0.0f;
    float mValueFour = 0.0f;
    boolean mAddition, mSubtract, mMultiplication, mDivision = false;

    public void calculate(String exp) {
        if (!mAddition && !mDivision && !mSubtract && !mMultiplication) {
            mValueOne = Float.parseFloat(mEditText.getText() + "");
            mValueFour = Float.parseFloat(mEditText.getText() + "");
            if (exp.equals("addition")) {
                mAddition = true;
            } else if (exp.equals("sub")) {
                mSubtract = true;
            } else if (exp.equals("division")) {
                mDivision = true;
            } else if (exp.equals("multiplication")) {
                mMultiplication = true;
            }
            mEditText.setText(null);
        } else if (mAddition) {
            mValueTwo = Float.parseFloat(mEditText.getText() + "");
            mValueFour = mValueFour + mValueTwo;
            mEditText.setText(null);
        } else if (mSubtract) {
            mValueTwo = Float.parseFloat(mEditText.getText() + "");
            mValueFour = mValueFour - mValueTwo;
            mEditText.setText(null);
        } else if (mMultiplication) {
            mValueTwo = Float.parseFloat(mEditText.getText() + "");
            mValueFour = mValueFour * mValueTwo;
            mEditText.setText(null);
        } else if (mDivision) {
            mValueTwo = Float.parseFloat(mEditText.getText() + "");
            mValueFour = mValueFour / mValueTwo;
            mEditText.setText(null);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button goBack = findViewById(R.id.go_to_main);
        goBack.setOnClickListener(this);
        mButton0 = (Button) findViewById(R.id.button0);
        mButton1 = (Button) findViewById(R.id.button1);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton3 = (Button) findViewById(R.id.button3);
        mButton4 = (Button) findViewById(R.id.button4);
        mButton5 = (Button) findViewById(R.id.button5);
        mButton6 = (Button) findViewById(R.id.button6);
        mButton7 = (Button) findViewById(R.id.button7);
        mButton8 = (Button) findViewById(R.id.button8);
        mButton9 = (Button) findViewById(R.id.button9);
        mButtonPoint = (Button) findViewById(R.id.buttonPoint);
        mButtonAdd = (Button) findViewById(R.id.buttonAdd);
        mButtonSub = (Button) findViewById(R.id.buttonSub);
        mButtonDiv = (Button) findViewById(R.id.buttonDiv);
        mButtonMul = (Button) findViewById(R.id.buttonMul);
        mButtonEq = (Button) findViewById(R.id.buttonEq);
        mButtonSqrt = (Button) findViewById(R.id.buttonSqrt);
        mButton2Deg = (Button) findViewById(R.id.button2Deg);
        mButtonM = (Button) findViewById(R.id.buttonM);
        mButtonMC = (Button) findViewById(R.id.buttonMC);

        mEditText = (EditText) findViewById(R.id.editText);


        //Реализация функционала (необходимые методы)
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(mEditText.getText() + "1");
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(mEditText.getText() + "2");
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(mEditText.getText() + "3");
            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(mEditText.getText() + "4");
            }
        });
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "5");
            }
        });
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "6");
            }
        });
        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "7");
            }
        });
        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "8");
            }
        });
        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "9");
            }
        });
        mButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "0");
            }
        });

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("addition");
                mSubtract = false;
                mDivision = false;
                mMultiplication = false;
                mAddition = true;
            }
        });
        mButtonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("sub");
                mAddition = false;
                mDivision = false;
                mMultiplication = false;
                mSubtract = true;
            }
        });
        mButtonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("multiplication");
                mAddition = false;
                mDivision = false;
                mSubtract = false;
                mMultiplication = true;
            }
        });
        mButtonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("division");
                mAddition = false;
                mMultiplication = false;
                mSubtract = false;
                mDivision = true;
            }
        });

        mButtonEq.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                mValueTwo = Float.parseFloat(mEditText.getText() + "");
                if (mAddition) {
                    mEditText.setText(mValueFour + mValueTwo + "");
                    mAddition = false;
                }
                if (mSubtract) {
                    mEditText.setText(mValueFour - mValueTwo + "");
                    mSubtract = false;
                }
                if (mMultiplication) {
                    mEditText.setText(mValueFour * mValueTwo + "");
                    mMultiplication = false;
                }
                if (mDivision) {
                    mEditText.setText(mValueFour / mValueTwo + "");
                    mDivision = false;
                }
            }
        });

        mButtonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(mEditText.getText() + ".");
            }
        });

        mButtonSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mValueOne = Float.parseFloat(mEditText.getText() + "");
                mEditText.setText(Math.sqrt(mValueOne) + "");
            }
        });

        mButtonMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(null);
                mValueOne = 0.0f;
                mValueTwo = 0.0f;
            }
        });

        mButtonM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditText == null || mEditText.getText().equals("")) {
                    mEditText.setText(mValueThree + "");
                } else {
                    mValueThree += Float.parseFloat(mEditText.getText() + "");
                    mEditText.setText(mValueThree + "");
                }
            }
        });

        mButton2Deg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditText == null || mEditText.getText().equals("")) {
                    mEditText.setText("");
                } else {
                    mValueOne = Float.parseFloat(mEditText.getText() + "");
                    mEditText.setText((mValueOne * mValueOne) + "");
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.go_to_main) {
            EditText result = findViewById(R.id.editText);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("result", result.getText().toString());
            startActivity(intent);
        }
    }
}