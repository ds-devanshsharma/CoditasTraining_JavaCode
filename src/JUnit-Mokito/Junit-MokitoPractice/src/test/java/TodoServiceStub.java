import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
    @Override
    public List<String> retrieveTodos() {
        return Arrays.asList("Learn Spring MVC "
                ,"Learn Spring ",
                "learn to dance");
    }
}
