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

## Check if the list contains the number 5

### Python

```
my_list = [10, 3, 5, 8, 7]
# True if the list contains the element
result = (5 in my_list)
```

### Java

```
List<Integer> myList = new ArrayList(Arrays.asList(10, 3, 5, 8, 7));
// True if the list contains the element
result = myList.contains(5);
```

## Filter to obtain all elements greater than 5

### Python

```
my_list = [10, 3, 5, 8, 7]
# get the list of elements greater than 5
result = filter(lambda x: x > 5, my_list)
```

### Java

```
List<Integer> myList = new ArrayList(Arrays.asList(10, 3, 5, 8, 7));
List<Integer> filteredList = new ArrayList<>();
for (Integer element : myList) {
    if (element.intValue() > 5) {
	filteredList.add(element);
    }
}
// filteredList contains all elements greater than 5
```

## Increment all elements by 1

### Python

```
my_list = [10, 3, 5, 8, 7]
result = map(lambda x: x + 1, my_list)
```

### Java

```
List<Integer> myList = new ArrayList(Arrays.asList(10, 3, 5, 8, 7));
List<Integer> remappedList = new ArrayList<>();
for (Integer element : myList) {
    remappedList.add(Integer.valueOf(element.intValue() + 1))
}
// remappedList contains the incremented elements
```

## Multiply all elements together

### Python

```
my_list = [10, 3, 5, 8, 7]
result = reduce(lambda x, y: x * y, my_list)
```

### Java

```
List<Integer> myList = new ArrayList(Arrays.asList(10, 3, 5, 8, 7));
int acc = 1;
for (Integer element : myList) {
    acc = acc * elememnt.intValue();
}
// acc has now the result of the produc of all the elements
```

