import javax.swing.*;
import java.awt.*;

public class ToDoListView extends JFrame {
    JButton addButton, deleteButton, editButton, toggleCompleteButton;
    JTextField textField;
    JList<ToDoItem> list;
    DefaultListModel<ToDoItem> model;

    public ToDoListView() {
        setTitle("ToDo List");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        initializeComponents();
        layoutComponents();
    }

    private void initializeComponents() {
        model = new DefaultListModel<>();
        list = new JList<>(model);
        list.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Margin für die Liste

        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        editButton = new JButton("Edit");
        toggleCompleteButton = new JButton("Check");

        textField = new JTextField(20);
    }

    private void layoutComponents() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panel.add(textField);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(editButton);
        panel.add(toggleCompleteButton);

        JScrollPane scrollPane = new JScrollPane(list);
        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }

    public void setModel(DefaultListModel<ToDoItem> model) {
        list.setModel(model);
    }
}
