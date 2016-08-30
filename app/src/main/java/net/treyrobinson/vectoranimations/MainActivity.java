package net.treyrobinson.vectoranimations;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private AnimatedVectorDrawable mapVectorDrawable;
    private AnimatedVectorDrawable menuVectorDrawable;

    ImageView image;
    Button animateButton;

    private boolean isShowingMap = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapVectorDrawable = (AnimatedVectorDrawable)getDrawable(R.drawable.map_to_menu);
        menuVectorDrawable = (AnimatedVectorDrawable)getDrawable(R.drawable.menu_to_map);
        image = (ImageView)findViewById(R.id.image);
        animateButton = (Button)findViewById(R.id.animate);

        animateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.animate();
            }
        });
    }

    private void animate() {
        AnimatedVectorDrawable prevDrawable = isShowingMap ? menuVectorDrawable:  mapVectorDrawable;
        if (prevDrawable.isRunning()) {
            prevDrawable.stop();
        }

        AnimatedVectorDrawable currentDrawable = isShowingMap ? mapVectorDrawable : menuVectorDrawable;;
        image.setImageDrawable(currentDrawable);
        currentDrawable.start();
        isShowingMap = !isShowingMap;


    }
}
