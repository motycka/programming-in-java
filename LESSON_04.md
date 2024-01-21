# Lesson 4

- Polymorphism
- Inheritance
- Generics


## Practice

### Exercise 1
TODO

### Exercise 2
TODO

### Exercise 3
TODO

## Homework

Create interface called `Encoder` with two methods, one do encode a String message and the other to decode it like this:
```
interface Encoder {

    String encode(String message);

    String decode(String message);
}
```
The purpose of this interface is to take a String and encode it somehow.
It should also be able to take encoded message and decode it back to its original form.

Create at least two implementations of this interface.
I don't care if your implementation is simple or complex, I leave the encoding and decoding method up to you. 

Here are some ideas:
- just reverse the message
- add some salt and reverse the message, you may pass the salt as a constructor parameter
- reverse letters in each word and also add some salt
- you can use substitution cipher - switch characters based on a dictionary

Then, of course, unit test your implementations.

### Expected delivery
You may crete a main program, but I will evaluate your implementation mainly based on tests.
Try to be thorough in verifying your implementations work correctly.
