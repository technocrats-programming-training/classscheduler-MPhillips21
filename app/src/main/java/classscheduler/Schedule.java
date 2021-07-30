package classscheduler;

public class Schedule {
    Class[] classesInSchedule;
    Class[] availableClassesReference;

    public Schedule(Class initialFiller, Database classStorage) {
      this.classesInSchedule = new Class[4];
      for(int c = 0; c < 4; c++) {
        classesInSchedule[c] = initialFiller;
      }
      availableClassesReference = classStorage.availableClasses;
    }
    
    public Class[] add(int classID, Class addReplacement) {
      Class classToAdd = availableClassesReference[classID];
      if(classesInSchedule[classToAdd.block - 1] == addReplacement) {
        classesInSchedule[classToAdd.block - 1] = classToAdd;
      availableClassesReference[classToAdd.ID] = addReplacement;
      } else {
        System.out.println("Block " + classToAdd.block + " is already full." + "\n");
      }
      
      return classesInSchedule;
    }

    public Class[] drop(int blockToDrop, Class dropReplacement) {
      Class classToDrop = classesInSchedule[blockToDrop];
      availableClassesReference[classToDrop.ID] = classToDrop;
      classesInSchedule[blockToDrop] = dropReplacement;
      return classesInSchedule;
    }

    public void view() {
      for(int v = 1; v < 5; v++) {
        System.out.println("Block " + v + ": " + classesInSchedule[v-1].name);
      }
      System.out.print("\n");
    }

    public void viewAvailable(Class filler) {
      for(int a = 0; a < availableClassesReference.length; a++) {
        if(availableClassesReference[a] != filler) {
          System.out.println("ID: " + availableClassesReference[a].ID + ", Block: " + availableClassesReference[a].block + ", Name: " + availableClassesReference[a].name + ", Teacher: " + availableClassesReference[a].teacher);
        }
      }
      System.out.print("\n");
    }

}