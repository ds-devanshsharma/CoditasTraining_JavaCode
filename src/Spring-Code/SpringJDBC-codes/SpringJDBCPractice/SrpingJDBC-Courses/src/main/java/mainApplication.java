import DAO.Implementation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class mainApplication {
    static Implementation implementation;
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        implementation = context.getBean("jdbcTemplate",DAO.Implementation.class);
        implementation.method();
    }
}
