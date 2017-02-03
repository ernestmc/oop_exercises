import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// Class for testing collections in Java
class TestCollections {
    
  interface Filter<T> {
      public boolean evaluate(T element);
  }
  
  class FilterList<T> {
      private Filter evaluator;
      
      public FilterList(Filter evaluator) {
          this.evaluator = evaluator;
      }
      
      public List<T> filter(List<T> inputList) {
          List<T> filteredList = new ArrayList<>();
          for (T element : inputList) {
              if (evaluator.evaluate(element)) {
                  filteredList.add(element);
              }
          }
          return filteredList;
      }
  }
  
  public static void main(String[] args) {
    System.out.println("Testing collections in Java.");
    TestCollections app = new TestCollections();
    app.test();
  }

  private void test() {
    List<Integer> myList = new ArrayList(Arrays.asList(10, 3, 5, 8, 7));
    System.out.println(myList);
    
    System.out.println("first: " + myList.get(0));
    System.out.println("last: " + myList.get(myList.size() - 1));
    System.out.println("at 4: " + myList.get(4));
    System.out.println("index of 7: " + myList.indexOf(7));
    System.out.println("size: " + myList.size());
    System.out.println("includes 5?: " + myList.contains(5));
    System.out.println("includes 23?: " + myList.contains(23));
    FilterList<Integer> myFilter = new FilterList(new Filter<Integer>() {
            public boolean evaluate(Integer element) {
                return (element > 5);
            }
        });
    List<Integer> filteredList = myFilter.filter(myList);
    System.out.println("elements greater than 5: " + filteredList);
  }
}
