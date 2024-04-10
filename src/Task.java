import java.io.Serializable;
import java.util.Objects;

public class Task implements Serializable {
    // private instance variables
    private String deadline, dueDate, name;
    private int priority;
    // Constructor

    public Task(String name, String dueDate, String deadline, int priority) {
        this.name = name;
        this.dueDate = dueDate;
        this.deadline = deadline;
        this.priority = priority;
    }

    // All the stuff
    public String getDeadline() {return deadline;}
    public void setDeadline(String deadline) {this.deadline = deadline;}
    public String getDueDate() {return dueDate;}
    public void setDueDate(String dueDate) {this.dueDate = dueDate;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getPriority() {return priority;}
    public void setPriority(int priority) {this.priority = priority;}
    // equals() + hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return priority == task.priority && Objects.equals(deadline, task.deadline) && Objects.equals(dueDate, task.dueDate) && Objects.equals(name, task.name);
    }
    @Override
    public int hashCode() {return Objects.hash(deadline, dueDate, name, priority);}
    // toString()

    @Override
    public String toString() {
        return "Task[" +
                "name=" + name +
                ", dueDate=" + dueDate +
                ", deadline=" + deadline +
                ", priority=" + priority +
                "]\n";
    }
}
