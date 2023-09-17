package com.codr.cleanbin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class WasteTypesInfoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waste_types);

        TextView wasteInfoTextView = findViewById(R.id.textViewWasteInfoContent);
        wasteInfoTextView.setText(getString(R.string.waste_info_content));

    }
}
