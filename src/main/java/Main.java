import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            ToDoListView view = new ToDoListView();
            DefaultListModel<ToDoItem> model = new DefaultListModel<>();
            view.setModel(model);
            new ToDoListController(view, model);
            view.setVisible(true);
        });
    }
}
