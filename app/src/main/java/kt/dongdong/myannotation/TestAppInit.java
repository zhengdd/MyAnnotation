package kt.dongdong.myannotation;

import android.app.Application;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestAppInit {

    public static void init(Application application) {

        try {
            Class<?> clazz = Class.forName("kt.dongdong.annotationlib.AllInit");
            Class[] parameterTypes = {Application.class};
            Constructor constructor = clazz.getConstructor(parameterTypes);
            Object object = constructor.newInstance(application);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

}
