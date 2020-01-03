package tatastrive.application.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    int[] img = {R.drawable.image_one, R.drawable.image_two, R.drawable.image_three, R.drawable.image_four};
    int length1 = img.length;
    int currentindex = -1;
    ImageSwitcher imageSwitcher;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main);

        imageSwitcher = findViewById( R.id.image );
        button = findViewById( R.id.button );
        imageSwitcher.setFactory( new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView( getApplicationContext() );

                imageView.setScaleType( ImageView.ScaleType.FIT_CENTER );

                imageView.setLayoutParams( new ImageSwitcher.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT ) );
                return imageView;
            }
        } );

        Animation right=AnimationUtils.loadAnimation( this,R.anim.right );
        Animation left=AnimationUtils.loadAnimation( this,R.anim.left);


        imageSwitcher.setOutAnimation(right);
        imageSwitcher.setOutAnimation( left );

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentindex++;
                if (currentindex == length1) {

                    currentindex = 0;
                }
                imageSwitcher.setImageResource( img[currentindex]);
            }

        } );

    }
}
