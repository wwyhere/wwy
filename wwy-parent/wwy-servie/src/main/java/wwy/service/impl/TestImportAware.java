package wwy.service.impl;

import java.util.Map;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

@Configuration
@SuppressWarnings("unused")
public class TestImportAware implements ImportAware, BeanClassLoaderAware {

    private String author;
    private String version;

    private ClassLoader classLoader;

    public void setImportMetadata(AnnotationMetadata importMetadata) {
        System.out.println(12345);
        Map<String, Object> enableAttrMap = importMetadata.getAnnotationAttributes(TestAnnotation.class.getName());
        AnnotationAttributes enableAttrs = AnnotationAttributes.fromMap(enableAttrMap);
        if (enableAttrs == null) {
        	return;
        }
        System.out.println(enableAttrs.getString("author"));
        version = enableAttrs.getString("version");
        author = enableAttrs.getString("author");
        setVersion(enableAttrs.getString("version"));
        setAuthor(enableAttrs.getString("author"));
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

}
