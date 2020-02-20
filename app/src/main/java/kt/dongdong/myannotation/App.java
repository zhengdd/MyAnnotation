package kt.dongdong.myannotation;

import android.app.Application;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        TestAppInit.init(this);
    }
}
