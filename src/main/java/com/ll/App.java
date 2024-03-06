package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("할일 관리앱, 시작");

        List<Todo> todos = new ArrayList<>();
        long lastTodoId = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("명령) ");

                String command = scanner.nextLine().trim();

                if (command.equals("add")) {
                    long todoId = lastTodoId + 1;

                    System.out.print("할일 : ");
                    String todoContent = scanner.nextLine().trim();
                    Todo todo = new Todo(todoId, todoContent);

                    lastTodoId++;

                    todos.add(todo);

                    System.out.printf("%d번 할일이 추가되었습니다.\n", todoId);
                } else if (command.equals("list")) {
                    System.out.println("목록");

                    System.out.println("번호 / 내용");

                    for (Todo todo : todos) {
                        System.out.println(todo.getId() + " : " + todo.getContent());
                    }

                } else if (command.equals("update")) {
                    System.out.print("수정할 할일의 번호 : ");
                    long todoId = Long.parseLong(scanner.nextLine().trim());

                    Todo foundTodo = todos
                            .reversed()
                            .stream()
                            .filter(todo -> todo.getId() == todoId)
                            .findFirst()
                            .orElse(null);

                    if (foundTodo == null) {
                        System.out.println("존재하지 않는 할일번호 입니다.");
                        continue;
                    }

                    System.out.printf("기존 할일 : %s\n", foundTodo.getContent());
                    System.out.print("새 할일 : ");
                    String content = scanner.nextLine().trim();
                    foundTodo.setContent(content);

                    System.out.printf("%d번 할일이 수정되었습니다.\n", todoId);

                } else if (command.equals("delete")) {
                    System.out.print("삭제할 할일의 번호 : ");
                    long todoId = Long.parseLong(scanner.nextLine().trim());

                    Todo foundTodo = todos
                            .reversed()
                            .stream()
                            .filter(todo -> todo.getId() == todoId)
                            .findFirst()
                            .orElse(null);

                    if (foundTodo == null) {
                        System.out.println("존재하지 않는 할일번호 입니다.");
                        continue;
                    }

                    todos.removeIf(todo -> todo.getId() == todoId);

                    System.out.printf("%d번 할일이 삭제되었습니다.\n", todoId);
                } else if (command.equals("exit")) {
                    break;
                }
            }
        }

        System.out.println("할일 관리앱, 끝");
    }
}
