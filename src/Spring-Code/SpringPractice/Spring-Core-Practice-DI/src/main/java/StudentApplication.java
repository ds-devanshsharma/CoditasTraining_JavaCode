
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApplication {
    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
            Student student = (Student) context.getBean("obj");
            System.out.println(student.getName());
            System.out.println(student.getName());
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
