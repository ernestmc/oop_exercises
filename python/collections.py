# Testing collections in Python

my_list = [10, 3, 5, 8, 7]

print "first: %d" % my_list[0]
reverse_list = list(my_list)
reverse_list.reverse()
print "last: %d" % reverse_list[0]
print "at 4: %d" % my_list[4]
for i in range(len(my_list)):
  if my_list[i] == 7:
      break
print "index of 7: %d" %i
print "size: %d" % len(my_list)
my_set = set(my_list)
print "includes 5? %s" % my_set.issuperset([5])
print "includes 23? %s" % my_set.issuperset([23])
print "elements greater than 5: %s" % filter(lambda x: x > 5, my_list)
print "+1 to each element: %s" % map(lambda x: x + 1, my_list)
print "sum all elements: %d" % sum(my_list)
print "multiply all elements: %d" % reduce(lambda x, y: x * y, my_list)
