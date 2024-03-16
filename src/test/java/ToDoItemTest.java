import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ToDoItemTest {

    @Test
    void creatingToDoItemShouldSetDescriptionCorrectly() {
        ToDoItem item = new ToDoItem("Finish homework");
        assertEquals("Finish homework", item.getDescription(), "The description should match the constructor argument.");
    }

    @Test
    void settingDescriptionShouldWorkCorrectly() {
        ToDoItem item = new ToDoItem("Finish homework");
        item.setDescription("Complete exercise");
        assertEquals("Complete exercise", item.getDescription(), "setDescription should update the description.");
    }

    @Test
    void newItemShouldNotBeCompleted() {
        ToDoItem item = new ToDoItem("Finish homework");
        assertFalse(item.isCompleted(), "Newly created item should not be completed.");
    }

    @Test
    void completingItemShouldWorkCorrectly() {
        ToDoItem item = new ToDoItem("Finish homework");
        item.setCompleted(true);
        assertTrue(item.isCompleted(), "setCompleted(true) should mark the item as completed.");
    }
}
