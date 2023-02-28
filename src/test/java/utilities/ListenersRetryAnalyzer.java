package utilities;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
public class ListenersRetryAnalyzer implements IAnnotationTransformer {
    //    Bu sinifin amaci, TUM FAILE TEST CASELERI BIR KEZ DAHA AUTOMATIK OLARAK RUN ETMEK
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
//        Bu sinif ListenersRetry util classina baglidir
        annotation.setRetryAnalyzer(ListenersRetry.class);
    }
}