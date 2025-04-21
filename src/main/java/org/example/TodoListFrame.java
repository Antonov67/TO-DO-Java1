package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class TodoListFrame extends JFrame {
    private final TaskTableModel tableModel;
    private final RetrofitService service;
    private JTable taskTable;

    public TodoListFrame() {
        this.tableModel = new TaskTableModel();
        this.service = new RetrofitService();

        initializeUI();
        loadTasks();
    }

    private void initializeUI() {
        setTitle("ToDo List with PocketBase");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Таблица задач
        taskTable = new JTable(tableModel);
        add(new JScrollPane(taskTable), BorderLayout.CENTER);

        // Панель кнопок
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add Task");
        // addButton.addActionListener(this::addTask);

        JButton completeButton = new JButton("Toggle Complete");
        // completeButton.addActionListener(this::toggleComplete);

        JButton deleteButton = new JButton("Delete Task");
        // deleteButton.addActionListener(this::deleteTask);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> loadTasks());

        buttonPanel.add(addButton);
        buttonPanel.add(completeButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadTasks() {
        service.getTasks(new SimpleDataCallback<ResponseTasks>() {
            @Override
            public void load(ResponseTasks data) {
                tableModel.setTasks(data.getItems());
            }
        });
    }
}
