import config.Database;
import entities.repositories.TodoListRepositoryDbImpl;
import entities.repositories.TodoListRepository;
import entities.services.TodoListService;
import entities.services.TodoListServiceImpl;
import entities.views.TodoListTerminalView;
import entities.views.TodoListView; // Fixed typo


public class Main {
    public static void main(String[] args) {
        Database database = new Database("db_hazael", "root", "", "Localhost", "3306");
        database.setup();

        TodoListRepository todoListRepository = (TodoListRepository) new TodoListRepositoryDbImpl(database);


        TodoListService todoListService = (TodoListService) new TodoListServiceImpl(todoListRepository);


        TodoListView todoListView = (TodoListView) new TodoListTerminalView(todoListService);

        todoListView.run();
    }
}