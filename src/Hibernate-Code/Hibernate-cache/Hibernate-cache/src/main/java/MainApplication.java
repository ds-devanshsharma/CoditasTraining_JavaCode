import com.bean.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

public class MainApplication {
    static void firstLevelCache(){
        Employee employee ;
//        employee.setEmpID(11056);
//        employee.setName("Devansh");
//        employee.setCity("Kanpur");

        Employee employee1 = new Employee();
        employee1.setEmpID(12056);
        employee1.setName("Zulfa");
        employee1.setCity("Pune");

        Configuration configuration = new Configuration().
                configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        session.save(employee);
        session.save(employee1);
        session.getTransaction().commit();
        employee1 = session.get(Employee.class,12056);
        employee = session.get(Employee.class,11056);
        System.out.println(employee);
        System.out.println(employee1);

        session.close();

        System.out.println(sessionFactory.openSession().get(Employee.class,11056));
    }
    static void secondLevelCache(){
        Configuration configuration = new Configuration().
                configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Employee employee1 = new Employee();
        employee1.setEmpID(12057);
        employee1.setName("Zulfa");
        employee1.setCity("Pune");

        session.save(employee1);
        session.getTransaction().commit();
        session.close();

        Session session1 = sessionFactory.openSession();
        System.out.println(session1.get(Employee.class,12057));
//        System.out.println(session1.get(Employee.class,12056));
        session1.close();



    }
    public static void main(String[] args) {
        secondLevelCache();
    }
}
/*
if we are using same session and performing multiple operations
then in that case
It will not hamper database again & again it will perform operation from the buffer area
where
object stays untill unless that session is closed;

 */