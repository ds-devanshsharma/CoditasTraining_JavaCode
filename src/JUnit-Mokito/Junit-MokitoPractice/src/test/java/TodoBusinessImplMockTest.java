import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest extends TestCase {
    @Test
    public void testRetrieveTodosRelatedToSpringUsingMock(){
//        TodoService mockTodoService= mock(TodoService.class);
//        stub(mockTodoService.retrieveTodos("Parameter"))

        //mock creation
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC "
                ,"Learn Spring ",
                "learn to dance");
        //when is used to stub a method with return combination
        when(todoServiceMock.retrieveTodos()).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl =
                new TodoBusinessImpl(todoServiceMock);
        List<String> list = todoBusinessImpl.retrieveTodosRelatedToSpring("dance");
        assertEquals("Something went wrong 1 was expected !",1, list.size());
    }
}