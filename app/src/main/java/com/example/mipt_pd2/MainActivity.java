package com.example.mipt_pd2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edUserInfo;
    Button bntCount;

    TextView tvMain;

    Spinner spSelectionOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edUserInfo = findViewById(R.id.edUserInput);
        this.bntCount = findViewById(R.id.btnCount);
        this.tvMain = findViewById(R.id.tvMain);

        this.spSelectionOptions = (Spinner) findViewById(R.id.spSelectionOptions);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.selection_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spSelectionOptions.setAdapter(adapter);
    }

    public void onBtnCountClick(View view) {
        String selectedItem = this.spSelectionOptions.getSelectedItem().toString();
        if(selectedItem.equals("Symbols")){
            int result = TextCounter.countSymbols(this.edUserInfo.getText().toString());
            Log.i("CountResult", String.valueOf(result));
            this.tvMain.setText(String.valueOf(result));
        }
        else if(selectedItem.equals("Words")) {
            int result = TextCounter.countWords(this.edUserInfo.getText().toString());
            Log.i("CountResult", String.valueOf(result));
            this.tvMain.setText(String.valueOf(result));
        }
        else {
            Toast.makeText(this, "NOT INPLEMENTED", Toast.LENGTH_LONG).show();
        }
        if (this.edUserInfo.getText().toString().isEmpty()) {
            Toast.makeText(this, "THERE IS NO INPUT!", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
