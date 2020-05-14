package com.example.mentalmath;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.mentalmath.ui.dashboard.DashboardFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Tonny White on 2019-12-12.
 */
public class ComplicatedActivity extends AppCompatActivity {


    public int counter = 3;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();

    String[] listFormulFor10Items;
    boolean[]checkedItemsInFormul10;
    ArrayList<Integer> mUserItemsInFormulFor10 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_complicated);


        final TextView startButton = findViewById(R.id.startButton);
        final TextView countTV = findViewById(R.id.countDown);
        final EditText kolvoET = findViewById(R.id.kolva);
        final Button lawOfFiveBtn = findViewById(R.id.zakonFor5);
        final Button lawOfTenBtn = findViewById(R.id.zakonFor10);
        final EditText kolvoChisel = findViewById(R.id.kolvaChisel);
        final EditText razryadnostChisel = findViewById(R.id.razryadnostChisel);
        final EditText answerTV = findViewById(R.id.answerView);
        final TextView questionTV = findViewById(R.id.questionView);
        final TextView okTV = findViewById(R.id.okButton);

        answerTV.setVisibility(View.GONE);
        questionTV.setVisibility(View.GONE);
        okTV.setVisibility(View.GONE);

        listItems = getResources().getStringArray(R.array.law_for_5);
        checkedItems = new boolean[listItems.length];

        lawOfFiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(ComplicatedActivity.this);
                mBuilder.setTitle(R.string.zakon5);
                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        if(isChecked){
                            if (!mUserItems.contains(position)) {
                                mUserItems.add(position);
                            }
                        } else if (mUserItems.contains(position)){
                                mUserItems.remove(position);
                            }
//                            mUserItems.add(which);
//                        }else{
//                            mUserItems.remove((Integer.valueOf(which)));
//                        }

                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = "";
                        for(int i = 0; i < mUserItems.size(); i++){
                            item = item + listItems[mUserItems.get(i)];
                            if(i != mUserItems.size() -1){
                                item = item + " , ";
                            }

                        }
                    }
                });

                mBuilder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                mBuilder.setNeutralButton("Почистить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < checkedItems.length; i++){
                            checkedItems[i] = false;
                            mUserItems.clear();

                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }

        });



        listFormulFor10Items = getResources().getStringArray(R.array.formul_for_10);
        checkedItemsInFormul10 = new boolean[listFormulFor10Items.length];


        lawOfTenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(ComplicatedActivity.this);
                mBuilder.setTitle(R.string.formul_for_10);
                mBuilder.setMultiChoiceItems(listFormulFor10Items, checkedItemsInFormul10, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        if(isChecked){
                            if (!mUserItemsInFormulFor10.contains(position)) {
                                mUserItemsInFormulFor10.add(position);
                            }
                        } else if (mUserItemsInFormulFor10.contains(position)){
                            mUserItemsInFormulFor10.remove(position);
                        }
//                            mUserItems.add(which);
//                        }else{
//                            mUserItems.remove((Integer.valueOf(which)));
//                        }

                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = "";
                        for(int i = 0; i < mUserItemsInFormulFor10.size(); i++){
                            item = item + listFormulFor10Items[mUserItemsInFormulFor10.get(i)];
                            if(i != mUserItemsInFormulFor10.size() -1){
                                item = item + " , ";
                            }

                        }
                    }
                });

                mBuilder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                mBuilder.setNeutralButton("Почистить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < checkedItemsInFormul10.length; i++){
                            checkedItemsInFormul10[i] = false;
                            mUserItemsInFormulFor10.clear();

                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();

            }
        });



        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startButton.setVisibility(View.GONE);
                kolvoET.setVisibility(View.GONE);
                lawOfFiveBtn.setVisibility(View.GONE);
                lawOfTenBtn.setVisibility(View.GONE);
                kolvoChisel.setVisibility(View.GONE);
                razryadnostChisel.setVisibility(View.GONE);


                final String kolvoZadach = kolvoET.getText().toString();
//                String kolvoChisel2 = kolvoChisel.getText().toString();
//                String razryadChisla = razryadnostChisel.getText().toString();



                new CountDownTimer(3000, 1000){
                    public void onTick(long millisUntilFinished){
                        countTV.setText(String.valueOf(counter));
                        counter--;
                    }
                    public  void onFinish(){
                        countTV.setText("START");
                        Thread thread = new Thread() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(4000);
                                } catch (InterruptedException e) {
                                }

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {


//                                questionTV.setText(number);
                                        countTV.setVisibility(View.GONE);
                                        answerTV.setVisibility(View.VISIBLE);
                                        questionTV.setVisibility(View.VISIBLE);
                                        okTV.setVisibility(View.VISIBLE);


                                        final int b = Integer.valueOf(kolvoZadach);
                                        Random r = new Random();
                                        final int i1 = r.nextInt(10 - 0) + 0;


                                        int i;
                                        for(i = 1; i <= b; i++) {
                                            questionTV.setText(String.valueOf(i1));
                                            questionTV.postDelayed(this, 2000);
                                            if(i == b) break;
                                        }


                                        questionTV.post(new Runnable() {
                                            @Override
                                            public void run() {


                                            }
                                        });



//                                        final Handler h = new Handler();
//                                        final Runnable runnable = new Runnable() {
//
//                                            @Override
//                                            public void run() {
//                                                int b = Integer.valueOf(kolvoZadach);
//                                                int i;
//                                                for(i = 1; i <= b; i++) {
//                                                    Random r = new Random();
//                                                    int i1 = r.nextInt(10 - 0) + 0;
//                                                    questionTV. setText(String.valueOf(i1+ " " + i));
//                                                    h.postDelayed(this, 1200); //ms
//                                                }
//                                            }
//                                       };
//                                        h.postDelayed(runnable, 1200);






                                    }

                                });
                            }
                        };
                        thread.start(); //start the thread



                    }
                }.start();
//                Random r = new Random();
//
//                final StringBuffer temp =new StringBuffer();
//                for(int i=0;i<10;i++) {
//                    int i1 = r.nextInt(9 - 0) + 0;
//
//                    temp.append(String.valueOf(i1));
//                    temp.append(String.valueOf(" "));
//                }














            }
        });



    }




}