# Practice: Lesson 8

_Memory management, multi-threading_
---

## Task 1: Thread
Write a simple program, that creates an instance of Thread and does the following inside the thread:
1. prints "Barista is making your coffee"
2. waits for 5 seconds
3. prints "Your coffee is ready. Enjoy!"

## Task 2: Runnable
Implement the same functionality as in Task 1, but this time create a class that implements Runnable interface.
Then use the clas for creating of new thread.

## Task 3: Atomic Operations
Enhance your code, create an orders object that represents number of orders waiting to be processed.

Create while or do-while loop inside your Runnable class, that will decrease the number of orders by 1, 
every time a coffee is made. The loop should stop when the number of orders is 0.

Create two threads with your Runnable class that will process the orders in parallel.

## Task 4: Semaphore
Enhance your code, so that the coffee shop can process only coffee 1 order at a time, as there is only 1 coffee machine.

### Testing
You are not required to write unit tests for this lesson. But you can try if you want to.
