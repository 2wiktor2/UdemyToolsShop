package com.wiktor.toolsshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityDrillDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_details);

        ImageView imageViewPicture;
        imageViewPicture = findViewById(R.id.image_view_drill_picture_in_details);
        TextView textViewTitle = findViewById(R.id.text_view_drill_title_in_details);
        TextView textViewInfo = findViewById(R.id.text_view_drill_info_in_details);

        Bundle bundleExtras = getIntent().getExtras();
        if (bundleExtras != null) {
            String title = bundleExtras.getString("title");
            String info = bundleExtras.getString("info");
            int imageId = bundleExtras.getInt("resId", -1);

            textViewTitle.setText(title);
            textViewInfo.setText(info);
            imageViewPicture.setImageResource(imageId);
        } else{
            Intent backIntent = new Intent(this, ActivityDrillCategory.class);
            startActivity(backIntent);
        }

    }
}
