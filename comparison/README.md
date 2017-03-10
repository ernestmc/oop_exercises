# Comparing collections in Python and Java 7

## Define a list

### Python

```
my_list = [10, 3, 5, 8, 7]
```

### Java

```
List<Integer> myList = new ArrayList(Arrays.asList(10, 3, 5, 8, 7));
```

## Check if contains element

### Python

```
print "includes 5? %s" % my_set.issuperset([5])
```

### Java

```
System.out.println("includes 5?: " + myList.contains(5));
```

## Filter

### Python


```
print "elements greater than 5: %s" % filter(lambda x: x > 5, my_list)
```

### Java

```
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

FilterList<Integer> myFilter = new FilterList(new Filter<Integer>() {
    public boolean evaluate(Integer element) {
	return (element > 5);
    }
});
List<Integer> filteredList = myFilter.filter(myList);
System.out.println("elements greater than 5: " + filteredList);  
```

## Map

### Python

```
print "+1 to each element: %s" % map(lambda x: x + 1, my_list)
```

### Java

```
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

RemapList<Integer> myMapper = new RemapList(new Remapper<Integer>() {
    public Integer remap(Integer element) {
	return Integer.valueOf(element.intValue() + 1);
    }
});
List<Integer> remappedList = myMapper.remap(myList);
System.out.println("+1 to each element: " + remappedList);
```

## Reduce

### Python

```
print "multiply all elements: %d" % reduce(lambda x, y: x * y, my_list)
```

### Java

```
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

ReduceList<Integer> myMultReducer = new ReduceList<>(new Reducer<Integer>() {
    public Integer reduce(Integer acc, Integer element) {
	return Integer.valueOf(acc.intValue() * element.intValue());
    }
});
Integer mult = myMultReducer.reduce(Integer.valueOf(1), myList);
System.out.println("multiply all elements: " + mult.intValue());
```

