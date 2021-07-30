package classscheduler;

public class Database {
    Class[] availableClasses;

    public Database(int listSize) {
      this.availableClasses = new Class[listSize];
    }
      
    /*public Class[] createList(int listSize, Class fillerClass) {
      Class[] availableClasses = new Class[listSize];
      for(int f = 0; f < liseeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeetSize; f++) {
        availableClasses[f] = fillerClass;
      }
      return availableClasses;
    }*/

    public Class[] addToList(int classListID, Class addedClass) {
      availableClasses[classListID] = addedClass;
      return availableClasses;
    }
}