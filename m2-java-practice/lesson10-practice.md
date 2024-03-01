# Practice: Lesson 9

_Rest API_
___

## Task: Serialization through reflection
Create a class `Student` (or record) with the following fields:
- `id` of type `Long`
- `fullName` of type `String`
- `course` of type `Integer`
- `isEnrolled` of type `Boolean`
- `admissionDate` of type `LocalDate` 
- `graduationDate` of type `LocalDate` (optional, may be null)
- `grade` of type `Double` (optional, may be null)

Convert the class to JSON (String) using reflection. 
This means you will need to find all **public** fields of the class, convert them to JSON keys and assign their values as JSON values.

In JSON, some may fields may be optional, which is usually signified by `null` value. 
If a filed value is not, exclude it from serialization.

Don't forget to create unit tests for this task.

## Homework

I want you to get familiar with how to use REST APIs, how to GET, POST, PUT and DELETE data through it.

To do so, you can install a tool called [PostMan](https://www.postman.com) and learn how to use it.

I expect you to know how to do GET, POST, PUT and DELETE operations next week.

See [PostMan documentation](https://learning.postman.com/docs/introduction/overview/)
 - [Sending requests](https://learning.postman.com/docs/sending-requests/requests/)
 - [Requests](https://learning.postman.com/docs/sending-requests/requests/)


Here is a list of public REST APIs you can use to practice:
https://github.com/public-api-lists/public-api-lists
