package kt.dongdong.processlib;


import com.google.auto.service.AutoService;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

import kt.dongdong.annotationlib.InitApplication;

@AutoService(Processor.class)
public class InitProcess extends AbstractProcessor {


    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }


    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> setTypes = new HashSet<>();
        setTypes.add(InitApplication.class.getCanonicalName());
        return setTypes;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        // 参数annotations表示需要处理的注解的集合
        // 参数roundEnv通过getElementsAnnotatedWith方法可以获取对应使用注解的类

        if (annotations.isEmpty()) {
            return false;
        }
        for (TypeElement typeElement : annotations) {

            //判断是否是要解析的注解类
            if (typeElement.toString().equals(InitApplication.class.getCanonicalName())) {
                //获取对应列表
                Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(typeElement);
                StringBuilder strImpory = new StringBuilder();
                StringBuilder strNew = new StringBuilder();

                for (Element element : elements) {
                    strImpory.append("import " + element.toString() + ";\n");
                    strNew.append(element.getSimpleName() + " "
                            + element.getSimpleName().toString() + "C = new "
                            + element.getSimpleName() + "();\n");
                    strNew.append(element.getSimpleName().toString() + "C.init(application);\n");
                }
                try {
                    //通过processingEnv.getFiler()创建类文件并写入。
                    JavaFileObject fileObject = processingEnv.getFiler().createSourceFile("kt.dongdong.annotationlib.AllInit");
                    Writer writer = fileObject.openWriter();
                    writer.write("package kt.dongdong.annotationlib;\n\n");
                    writer.write("import android.app.Application;\n");
                    writer.write(strImpory.toString() + "\n\n\n");
                    writer.write("public class AllInit{\n\n");
                    writer.write("public AllInit(Application application){\n");
                    writer.write(strNew.toString());
                    writer.write("}\n}\n");
                    writer.close();//注意需要关闭流 不然文件没有内容

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


        return false;
    }
}
