package com.example.hw341;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.hw341.R.style.AppTheme_Blue;

public class MainActivity extends AppCompatActivity {

    private static int currentThemeRes = -1;
    String[] color = {"Зелёный", "Чёрный", "Синий"};
    Button btnOk;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (currentThemeRes != -1) {
            setTheme(currentThemeRes);
        }
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, color);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        init();
    }

    public void init() {
        btnOk = findViewById(R.id.button);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (spinner.getSelectedItem().toString()) {
                    case "Зелёный":
                        currentThemeRes = R.style.AppThemeGreen;
                        recreate();
                        break;
                    case "Синий":
                        currentThemeRes = R.style.AppTheme_Blue;
                        Toast.makeText(getApplicationContext(), "select ", Toast.LENGTH_SHORT).show();
                        recreate();
                        break;
                    case "Чёрный":
                        currentThemeRes = R.style.AppTheme_Black;
                        recreate();
                        break;
                }
            }
        });
    }
}
