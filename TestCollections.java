import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// Class for testing collections in Java
class TestCollections {
  public static void main(String[] args) {
    System.out.println("Testing collections in Java.");
    test();
  }

  private static void test() {
    List<Integer> myList = new ArrayList(Arrays.asList(10, 3, 5, 8, 7));
    System.out.println(myList);
    
    System.out.println("first: " + myList.get(0));
    System.out.println("last: " + myList.get(myList.size() - 1));
    System.out.println("at 4: " + myList.get(4));
    
  }
}
