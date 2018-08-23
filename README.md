# RTSCodingChallenge
Quick Repository for RTS Labs' Coding Challenge

These solutions were developed using Scala, and tested using ScalaTest.

## Problem 1
Print the number of integers in an array that are above the given input and the number that are below.

e.g. for the array [1, 5, 2, 1, 10] with input 6, print “above: 1, below: 4”.

### My Solution
I approach this problem with an O(n) solution by utilizing Scala's foldLeft method. 

FoldLeft is a common method in functional programming languages which allows you to iterate through a List (or in this case, an Array) while keeping an accumulator.

An appropriate accumulator for this situation would be a 2-tuple of accumulators that represent the number of values that we have seen so far that were above the pivot, and the number of values that were below the pivot.

In a similar fashion, we could have also brought along two Buffers in the accumulator tuple, and added elements to those Buffers and taken their length after processing was complete. However, it was not specified to report the elements, so this was not necessary.

## Problem 2
Rotate the characters in a string by a given input and have the overflow appear at the beginning 

e.g. “MyString” rotated by 2 is “ngMyStri”.

### My Solution
Upon doing case analysis, we are granted a bit of creativity with how we handle the case where the integer input is negative. In this case, I decided to see if I could rotate the string in the opposite direction.

I approach this problem again with an O(n) solution by utilizing Scala's splitAt method.

Scala's splitAt method takes a String and an index as input, and returns a 2-tuple containing the characters such that 
* String(i) < index, 

and the characters such that 
* String(i) >= index.

For example, "MyString".splitAt(2) will return ("My", "String")

This behavior is quite useful, because we can define a rotation as a concatenation between the resultant sub-strings. That is:
* String.rotate(k) === String.subString(0, k) + String.subString(k, len)

The only tricky piece is to get the indices to work as expected. To this extent, there are two main challenges:
1. Making sure that we pick the correct index.
Given that we are going to want to split the String, we have to understand that we should be indexing from the right hand side of the string. In other words, given an integer *k* to shift by, we want to take the rightmost *k* characters are place them at the front of the string.
* String.splitAt(len - k) = ( String.subString(0, len-k), String.subString(len-k, len) )
* String.rotate(k) = String.subString(len-k, len) + String.subString(0, len-k)
  * "MyString".rotate(2) = "ng" + "MyStri"

2. Making sure that larger numbers of rotations work as expected.

* Applying a 10 character shift to "MyString" is the same as applying a full 8 character shift 
  * "MyString" >> 8 = "MyString",
* and a 2 character shift from there 
  * "MyString" >> 2 = "ngMyStri"

By establishing the identity that a String being shifted by it's length is the same String, we can therefore adopt modular arithmetic to handle large shifts.

## Problem 3
If you could change 1 thing about your favorite framework/language/platform (pick one), what would it be?

### My Response
I would change Java to have a better interface for inserting multiple values into a collection. For example, when we want a list like:
* [1, 2, 3]
We can't simply do
```java
List<Integer> list = [1, 2, 3];
```
instead, we are forced to do something like
```java
List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
```
While this is a small issue, this is quite burdensome when writing tests and initializing constant Collections that you wish to query against (such as blacklists).

On the other hand, Java has seen major improvements that bring in a lot of functional programming paradigms, such as Streams, and first class functions (those that can be passed as values). This has made Java a more readible language when it comes to filtering over collections, and iterating over for loops.

One example would be the problem of finding the number of odd length words, greater than *x* characters in a list. We might right an imperative version like so:

```java
public List<String> oddLengthLongerThanX(List<String> words, Integer x) {
  LinkedList<String> results = new LinkedList<>();
  
  for (String word : words) {
    int length = word.size();
    if (length > x && length % 2 == 1) {
      results.add(word);
    }
  }

  return results;
}
```

Notice how when you were reading over the code, as you hit the conditional inside the for loop, your eyes had to do a few jumps to kind of figure out what was going on. You have to remember that we are looking for length greater than x, the length to be odd, and the fact that both of these must be true in order to add.

Now with Java 8 and above, you can do something much more readible:

```java
public List<String> oddLengthLongerThanX(List<String> words, Integer x) {
  return words.stream()
    .filter(word -> word.size() > x)
    .filter(word -> word.size() % 2 == 1)
    .collect(Collectors.toList());
}
```

Or even better:

```java
public List<String> oddLengthLongerThanX(List<String> words, Integer x) {
  return words.stream()
    .filter(word -> isGreaterThanXChars(word, x))
    .filter(word -> isOddLength(word))
    .collect(Collectors.toList());
}

private boolean isGreaterThanXChars(String word, Integer x) {
  return word.size() > x;
}

private boolean isOddLength(String word) {
  return word.size() % 2 == 1;
}
```

What about if your boss tells you this is too slow? What do you do?

Well you just make the stream parallel using **parallelStream()**!

```java
public List<String> oddLengthLongerThanX(List<String> words, Integer x) {
  return words.parallelStream()
    .filter(word -> isGreaterThanXChars(word, x))
    .filter(word -> isOddLength(word))
    .collect(Collectors.toList());
}

private boolean isGreaterThanXChars(String word, Integer x) {
  return word.size() > x;
}

private boolean isOddLength(String word) {
  return word.size() % 2 == 1;
}
```
