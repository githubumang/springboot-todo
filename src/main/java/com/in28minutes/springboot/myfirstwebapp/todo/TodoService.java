package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;
    static {
        todos.add(new Todo(++todosCount, "umang", "Learn Spring boot", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "umang", "Learn React", LocalDate.now().plusYears(2), true));
        todos.add(new Todo(++todosCount, "raju", "Learn AWS", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
        todos.add(new Todo(++todosCount, username, description, targetDate, isDone));
    }

    public void deleteById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findTodoById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(Todo newTodo) {
        Predicate<? super Todo> predicate = todos -> todos.getId() == newTodo.getId();
        Todo oldTodo = todos.stream().filter(predicate).findFirst().get();
        oldTodo.setDescription(newTodo.getDescription());
        oldTodo.setTargetDate(newTodo.getTargetDate());
    }
}
