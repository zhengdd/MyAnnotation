package kt.dongdong.myannotation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import kt.dongdong.annotationlib.InitApplication;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
