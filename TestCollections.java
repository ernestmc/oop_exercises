import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// Class for testing collections in Java
class TestCollections {
    
  interface Filter<T> {
    boolean evaluate(T element);
  }
      
  class FilterList<T> {
      private Filter<T> evaluator;
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
  
  interface Remapper<T> {
      T remap(T element);
  }
  
  class RemapList<T> {
      private Remapper<T> mapper;
      public RemapList(Remapper mapper) {
          this.mapper = mapper;
      }
      public List<T> remap(List<T> inputList) {
          List<T> remappedList = new ArrayList<>();
          for (T element : inputList) {
              remappedList.add(mapper.remap(element));
          }
          return remappedList;
      }
  }
  
  interface Reducer<T> {
      T reduce(T accumulator, T element);
  }
  
  class ReduceList<T> {
      private Reducer<T> reducer;
      public ReduceList(Reducer reducer) {
          this.reducer = reducer;
      }
      public T reduce(T initial, List<T> inputList) {
          T accumulator = initial;
          for (T element : inputList) {
              accumulator = reducer.reduce(accumulator, element);
          }
          return accumulator;
      }
  }
  
  public static void main(String[] args) {
    System.out.println("Testing collections in Java.");
    TestCollections app = new TestCollections();
    app.test();
  }

  private void test() {
    List<Integer> myList = new ArrayList(Arrays.asList(10, 3, 5, 8, 7));
    System.out.println("Original list: " + myList);
    
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
    RemapList<Integer> myMapper = new RemapList(new Remapper<Integer>() {
        public Integer remap(Integer element) {
            return Integer.valueOf(element.intValue() + 1);
        }
    });
    List<Integer> remappedList = myMapper.remap(myList);
    System.out.println("+1 to each element: " + remappedList);
    ReduceList<Integer> mySumReducer = new ReduceList<>(new Reducer<Integer>() {
        public Integer reduce(Integer acc, Integer element) {
            return Integer.valueOf(acc.intValue() + element.intValue());
        }
    });
    Integer sum = mySumReducer.reduce(Integer.valueOf(0), myList);
    System.out.println("sum all elements: " + sum.intValue());
    ReduceList<Integer> myMultReducer = new ReduceList<>(new Reducer<Integer>() {
        public Integer reduce(Integer acc, Integer element) {
            return Integer.valueOf(acc.intValue() * element.intValue());
        }
    });
    Integer mult = myMultReducer.reduce(Integer.valueOf(1), myList);
    System.out.println("multiply all elements: " + mult.intValue());
  }
}
