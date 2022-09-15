package Com.main;

import com.sun.org.apache.xml.internal.serializer.SerializationHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("ObjectDIConfig.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("InnerBeanConfig.xml");
        Com.bean.Shape shape =(Com.bean.Shape)context.getBean("shape");
        System.out.println(shape);

    }
}
