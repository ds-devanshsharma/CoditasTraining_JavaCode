import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoBusinessImpl {
    //TodoServiceImpl -> SUT
    //TodoService -> Dependency
    private TodoService todoService ;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(final String matcher) {
        return todoService.retrieveTodos().stream()
                .filter(item -> item.contains(matcher))
                .collect(Collectors.toList());
    }
}
