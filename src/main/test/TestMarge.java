import javac.actions.UserAction;
import javac.entity.Person;
import javac.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by timhuo on 2017/3/29.
 */
public class TestMarge {

    private ClassPathXmlApplicationContext ctx;

    @Before
    public void before(){
        ctx = new ClassPathXmlApplicationContext("spring.xml");
    }

    @Test
    public void testMarge(){
        UserService ser = (UserService) ctx.getBean("testService");
    }


    @Test
    public void testAction() throws Exception {
        UserAction action = (UserAction) ctx.getBean("userAction");
        action.execute();
    }

    @Test
    public void testHibernate(){
        SessionFactory sf=(SessionFactory)ctx.getBean("sessionFactory");
        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();
        Person p1 = new Person("人员1");
        session.save(p1);
        transaction.commit();
        session.close();
    }

    @Test
    public void testServiceAndDao(){
        UserService service=(UserService)ctx.getBean("userService");
//        service.save(new Person("Tom"));
    }

    @Test
    public void testServiceDelete(){
        UserService service=(UserService)ctx.getBean("userService");
        service.delete(2);
    }

    @Test
    public void testTranslationReadOnly(){
        UserService service=(UserService)ctx.getBean("userService");
//        service.findPersion(8);
    }

    @Test
    public void testTranslationRollback(){
        UserService service=(UserService)ctx.getBean("userService");
//        service.save(new Person("Tom2"));
    }
}
