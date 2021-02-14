package com.tiromansev.prefswrapperexample;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvUserName = (TextView) findViewById(R.id.tvUserName);
        final EditText edtUserName = (EditText) findViewById(R.id.edtUserName);
        Button btnSave = (Button) findViewById(R.id.btnSave);

        tvUserName.setText(AppPrefs.userName().getValue());
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppPrefs.userName().setValue(edtUserName.getText().toString());
            }
        });
    }
}
