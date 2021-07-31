package classscheduler;

public class Class {
    String name;
    String teacher;
    int block;
    int ID;

    public Class(String className, String classTeacher, int blockNumber, int ID) {
      name = className;
      teacher = classTeacher;
      block = blockNumber;
      this.ID = ID;
    }
}