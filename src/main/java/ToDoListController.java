import javax.swing.*;
import java.awt.event.ActionEvent;

public class ToDoListController {
    private final ToDoListView view;
    private final DefaultListModel<ToDoItem> model;

    public ToDoListController(ToDoListView view, DefaultListModel<ToDoItem> model) {
        this.view = view;
        this.model = model;

        view.addButton.addActionListener(this::addTask);
        view.deleteButton.addActionListener(this::deleteTask);
        view.editButton.addActionListener(this::editTask);
        view.toggleCompleteButton.addActionListener(this::toggleTaskCompletion);
    }

    private void addTask(ActionEvent e) {
        String text = view.textField.getText();
        if (!text.isEmpty()) {
            model.addElement(new ToDoItem(text));
            view.textField.setText("");
        }
    }

    private void deleteTask(ActionEvent e) {
        int selectedIndex = view.list.getSelectedIndex();
        if (selectedIndex != -1) {
            model.remove(selectedIndex);
        }
    }

    private void editTask(ActionEvent e) {
        int selectedIndex = view.list.getSelectedIndex();
        if (selectedIndex != -1) {
            ToDoItem item = model.getElementAt(selectedIndex);
            String newText = JOptionPane.showInputDialog(view, "Edit Task:", item.getDescription());
            if (newText != null && !newText.isEmpty()) {
                item.setDescription(newText);
                view.list.repaint();
            }
        }
    }

    private void toggleTaskCompletion(ActionEvent e) {
        int selectedIndex = view.list.getSelectedIndex();
        if (selectedIndex != -1) {
            ToDoItem item = model.getElementAt(selectedIndex);
            item.setCompleted(!item.isCompleted());
            view.list.repaint();
        }
    }
}
