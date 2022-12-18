package com.example.gozagol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    Button btnKeep, btnWear;
    TextView tvK, tvAbo, tvWeight, tvValue, tvOutput, tvOutput1, tvOutput2, tvOutput3;
    EditText etWeight, etValue;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etWeight = findViewById(R.id.etWeight);
        etValue = findViewById(R.id.etValue);
        tvK = findViewById(R.id.tvK);
        tvAbo = findViewById(R.id.tvAbout);
        tvWeight = findViewById(R.id.tvWeight);
        tvValue = findViewById(R.id.tvValue);
        tvOutput = findViewById(R.id.tvOutput);
        tvOutput1 = findViewById(R.id.tvOutput1);
        tvOutput2 = findViewById(R.id.tvOutput2);
        tvOutput3 = findViewById(R.id.tvOutput3);
        btnKeep = findViewById(R.id.btnKeep);
        btnWear = findViewById(R.id.btnWear);
        btnKeep.setOnClickListener((View.OnClickListener) this);
        btnWear.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnKeep:
                try {

                    double weight;
                    weight = Double.parseDouble(etWeight.getText().toString());
                    double value;
                    value = Double.parseDouble(etValue.getText().toString());
                    double total = weight * value;
                    double uruf;
                    uruf = weight - 85;
                    double pay1 = uruf <= 0 ? 0 : uruf * value;
                    double total1 = pay1 * 0.025;

                    tvOutput.setText("Total Value of Gold: RM " + total);
                    tvOutput1.setText("Uruf: RM " + uruf);
                    tvOutput2.setText("Zakat Payable: RM " + pay1);
                    tvOutput3.setText("Total Zakat: RM " + total1);

                } catch (NumberFormatException nfe) {

                    Toast.makeText(this, "Please enter valid number", Toast.LENGTH_SHORT).show();
                } catch (Exception exp) {
                    Toast.makeText(this, "Unknown Exception" + exp.getMessage(), Toast.LENGTH_SHORT).show();

                    Log.d("Exception", exp.getMessage());
                }
                break;

            case R.id.btnWear:
                try {

                    double weight;
                    weight = Double.parseDouble(etWeight.getText().toString());
                    double value;
                    value = Double.parseDouble(etValue.getText().toString());
                    double total = weight * value;
                    double uruf;
                    uruf = weight - 200;
                    double pay2 = uruf <= 0 ? 0 : uruf * value;
                    double total2 = pay2 * 0.025;

                    tvOutput.setText("Total Value of Gold: RM " + total);
                    tvOutput1.setText("Uruf: RM " + uruf);
                    tvOutput2.setText("Zakat Payable: RM " + pay2);
                    tvOutput3.setText("Total Zakat: RM " + total2);

                } catch (NumberFormatException nfe) {

                    Toast.makeText(this, "Please enter valid number", Toast.LENGTH_SHORT).show();
                } catch (Exception exp) {
                    Toast.makeText(this, "Unknown Exception" + exp.getMessage(), Toast.LENGTH_SHORT).show();

                    Log.d("Exception", exp.getMessage());
                }
                break;

        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.Calculator) {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }
        if (id == R.id.About) {
            Intent intent = new Intent(this, About2.class);
            startActivity(intent);
        }
        else if(id == R.id.action_exit)
        {
            AlertDialog.Builder builder  = new AlertDialog.Builder(this);
            builder.setMessage("Back?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", (dialog, id12) -> MainActivity2.this.finish())
                    .setNegativeButton("No", (dialog, id1) -> dialog.cancel());
            AlertDialog alert = builder.create();
            alert.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
