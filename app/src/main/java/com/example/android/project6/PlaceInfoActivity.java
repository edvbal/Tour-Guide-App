package com.example.android.project6;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Edvinas on 29/05/2017.
 */

public class PlaceInfoActivity extends AppCompatActivity{

    ImageView picture, placeIcon;
    TextView name;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_info);

        picture = (ImageView) findViewById(R.id.picture);
        placeIcon = (ImageView) findViewById(R.id.place_icon);

        name = (TextView) findViewById(R.id.name);
        description = (TextView) findViewById(R.id.description);

        Intent intent = getIntent();

        picture.setImageResource(intent.getIntExtra("picture",0));
        name.setText(intent.getStringExtra("name"));
        description.setText(intent.getStringExtra("description"));

        placeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Uri gmmIntentUri = Uri.parse("geo:?q="+intent.getStringExtra("address"));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
