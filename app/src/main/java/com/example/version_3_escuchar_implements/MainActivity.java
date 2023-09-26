package com.example.version_3_escuchar_implements;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements TextWatcher {

    EditText etNum1, etNum2, etNum3;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        etNum3 = findViewById(R.id.etNum3);
        tvResultado = findViewById(R.id.tvResultado);

        etNum1.addTextChangedListener(this);
        etNum2.addTextChangedListener(this);
        etNum3.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        // Este método se llama antes de que el texto cambie.
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        // Este método se llama cuando el texto cambia.
        calcularNumeroMasGrande();
    }

    @Override
    public void afterTextChanged(Editable editable) {
        // Este método se llama después de que el texto cambia.
    }

    private void calcularNumeroMasGrande() {
        String str1 = etNum1.getText().toString();
        String str2 = etNum2.getText().toString();
        String str3 = etNum3.getText().toString();

        try {
            double num1 = Double.parseDouble(str1);
            double num2 = Double.parseDouble(str2);
            double num3 = Double.parseDouble(str3);

            double mayor = Math.max(Math.max(num1, num2), num3);

            tvResultado.setText("El número más grande es: " + mayor);
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Por favor, ingrese números válidos.", Toast.LENGTH_SHORT).show();
        }
    }
}
