import junit.framework.TestCase;
import org.junit.Test;
import java.util.List;

public class TodoBusinessImplStubTest extends TestCase {
    @Test
    public void testRetrieveTodosRelatedToSpringUsingStub(){
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl =
                new TodoBusinessImpl(todoServiceStub);
        List<String> list = todoBusinessImpl.retrieveTodosRelatedToSpring("dance");
        assertEquals("Something went wrong 1 was expected !",1, list.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpringUsingStub2(){
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl =
                new TodoBusinessImpl(todoServiceStub);
        List<String> list = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
        assertEquals(2 , list.size());
    }
}