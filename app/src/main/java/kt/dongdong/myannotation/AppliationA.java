package kt.dongdong.myannotation;

import android.app.Application;
import android.util.Log;

import kt.dongdong.annotationlib.InitApplication;


@InitApplication
public class AppliationA {


    public void init(Application application) {

        Log.d("AppliationA","通过注解初始化了AppliationA类");

    }

}
