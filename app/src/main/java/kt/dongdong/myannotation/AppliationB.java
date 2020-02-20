package kt.dongdong.myannotation;

import android.app.Application;
import android.util.Log;

import kt.dongdong.annotationlib.InitApplication;


@InitApplication
public class AppliationB {


    public void init(Application application) {

        Log.d("AppliationB", "通过注解初始化了AppliationB类");
    }

}
