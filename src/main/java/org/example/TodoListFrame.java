package org.example;

import retrofit2.Call;

import javax.swing.*;
import java.util.Map;

public class TodoListFrame extends JFrame {
    private final TaskTableModel tableModel;
    private JTable taskTable;

    public TodoListFrame(){
        this.client = PocketBaseClient().create();
    }
}
