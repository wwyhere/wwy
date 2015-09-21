package service.test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.springframework.core.ResolvableType;
import org.springframework.core.annotation.AnnotationUtils;

import wwy.service.impl.TestAnnotationImpl;

/**
 * 
 * @author wwy
 * @date 2015年6月14日上午12:19:15
 */
public class ReflectTest {
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InterruptedException,
            ExecutionException {
        ArrayList<Integer> list = (ArrayList<Integer>) ResolvableType.forClassWithGenerics(ArrayList.class,
                Integer.class).getRawClass().newInstance();
        System.out.println(list);
        Annotation service = AnnotationUtils.findAnnotation(TestAnnotationImpl.class,
                wwy.service.impl.TestAnnotation.class);
        Annotation component = AnnotationUtils.getAnnotation(service, wwy.service.impl.TestAnnotation.class);
        System.out.println(component);
    }
}
