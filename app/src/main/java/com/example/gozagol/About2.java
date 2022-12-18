package com.example.gozagol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class About2 extends AppCompatActivity {

    ImageView ivG;
    TextView tvTitle, tvCopy, tvAbout, tvHyperlink;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about2);
        ivG = findViewById(R.id.ivG);
        tvTitle = findViewById(R.id.tvTitle);
        tvCopy = findViewById(R.id.tvCopy);
        tvAbout = findViewById(R.id.tvAbout);
        tvHyperlink = findViewById(R.id.tvHyperlink);
        setupHyperlink();
    }

    private void setupHyperlink(){
        TextView linkTextView = findViewById(R.id.tvHyperlink);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
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
                    .setPositiveButton("Yes", (dialog, id12) -> About2.this.finish())
                    .setNegativeButton("No", (dialog, id1) -> dialog.cancel());
            AlertDialog alert = builder.create();
            alert.show();
        }
        return super.onOptionsItemSelected(item);
    }

}