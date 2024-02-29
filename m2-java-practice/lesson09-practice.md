# Practice: Lesson 9

_Generics, Function as an argument, Functional Interface_
___

## Task 1: Generics
Create a generic `GiftBox` class, which has one private field representing an item to store in the box, and two methods: 
- `put` to put an item into the box
- `get` to get an item from the box

Define the item as generic type. The concrete type will be specified during class instantiation.

Create a unit test to text the `Box` with different types.

## Task 2: Function as a parameter
Create a function called `doMagic`that accepts three parameters:
- `item1` - any type you want
- `item2` - any type you want
- third parameters is a function, let's call it `magic`

The `magic` parameter function should apply `item1` and `item2` and return s value of any type.

Write a unit test to test the `doMagic` function.

### Hint
You can use BiFunction<T,U,R> as the third parameter.


## Task 3: Function as a parameter with generics
Enhance your doMagic function so that it accepts and returns generic types of T1, T2 and R.
The two input types and one return type may be different types!

Write a unit test to test the `doMagic` function.

## Task 4: Functional interface
Rewrite task 3 using functional interface.
