package classscheduler;

public class Database {

    static Class[] availableClasses;

    public static void setNumClasses(int numClasses) {
      avilableClasses = new Class[numClasses];
    }

    /*public Class[] createList(int listSize, Class fillerClass) {
      Class[] availableClasses = new Class[listSize];
      for(int f = 0; f < listSize; f++) {
        availableClasses[f] = fillerClass;
      }
      return availableClasses;
    }*/

    public static Class[] addToList(int classListID, Class addedClass) {
      availableClasses[classListID] = addedClass;
      return availableClasses;
    }
}