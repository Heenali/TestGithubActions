package com.example.myapplication.Lifecycle;



import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;

public class SampleActivity extends AppCompatActivity {

    private static final String COMMON_TAG = "CombinedLifeCycle";
    private static final String ACTIVITY_NAME = SampleActivity.class.getSimpleName();
    private static final String TAG = COMMON_TAG;


    private Button buttonAddFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sampleactivity);

       buttonAddFragment = (Button)findViewById(R.id.buttonAddFragment);

        buttonAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //addFragment();
                addActivity();
            }
        });
        Log.i(TAG, ACTIVITY_NAME+" onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, ACTIVITY_NAME+" onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, ACTIVITY_NAME + " onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, ACTIVITY_NAME+" onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, ACTIVITY_NAME+" onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, ACTIVITY_NAME+" onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, ACTIVITY_NAME+" onDestroy");
    }

    private void addFragment(){
        Fragment fragment=new SampleFragment();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer,fragment,"demofragment");
        fragmentTransaction.addToBackStack("fragmentStack1");
        fragmentTransaction.commit();
    }
    private void addActivity(){
        Intent i=new Intent(getApplicationContext(),SampleActivity2.class);
        startActivity(i);
    }
}
