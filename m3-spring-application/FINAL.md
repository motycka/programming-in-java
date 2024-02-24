# Fitness Tracker Application

## Description

The fitness tracker application allows users to track their fitness activities. 
The application has the following features:

1. Managing activity types
2. Tracking user activities
3. Managing users


## User Context
The application works in user context. Each user has a unique identifier, which is used to associate the user with 
their activities and activity types.

For the purpose of simplicity, we will not implement user authentication and authorization, 
but we will use a fixed user token on each request to identify the user.


## Managing Activity Types
The application allows users to manage activity types. An activity type is a type of activity that a user can perform.

There are two kinds of activity types:
- Application-defined activity types (DEFAULT)
- User-defined activity types (USER)

The following rules apply to activity types:
- **Application-defined** activity types are predefined in the application and cannot be modified or deleted.
- **User-defined activity** types are created by users and can be modified or deleted by the user who created them, under following conditions:
  - User-defined activity types cannot be deleted if they are used in any user activity.
  - User-defined activity types can be modified if they are used in any user activity, but the changes will be reflected in the user activities that have already been recorded.
  - User-defined activity types can be deleted if they are not used in any user activity.
  - Activity name must be unique for each user.

### Requirements

The application must be able to perform the following operations on activity types:
 - Get a list of all activity types
 - Get a list of activity types based on the type (DEFAULT or USER)
 - Get an activity type by its unique identifier
 - Add a new user activity type
 - Update an existing user activity type
 - Delete an existing user activity type, if it is not used in any user activity

### Model

**NewActivityType** - Defines activity types. It has the following properties:
 - **name** - The name of the activity.
 - **userId** - The unique identifier of the user who added the activity.
 - **caloriesPerMinute** - The number of calories burned per minute during the activity.

**ActivityType** - Defines activity types. It has the following properties:
 - **id** - The unique identifier of the activity.
 - **type** - The type of the activity.
 - **userId** - The unique identifier of the user who added the activity.
 - **name** - The name of the activity.
 - **caloriesPerMinute** - The number of calories burned per minute during the activity.


## Tracking User Activities

The application allows users to track their activities. A user activity is a record of a user's activity and is based on an activity type.

## Requirements

The following rules apply to user activities:
 - User can add a new activity based on an activity type.
   - user activity **must** be associated with a user and an activity type.
   - user activity **must** have a start time, duration, and distance.
   - user activity **can** have an average heart rate and additional notes.
 - A user activity may be updated or deleted only by the user who added it.
 - User can list all activities.
 - User can list activities filtered by 
   - date
   - activity type
   - or duration.
 - User can get an activity by its unique identifier.
 - User activity returns a calculated number of calories burned based on the activity type and the duration of the activity.

### Model

**NewUserActivity** - Records the user's activity. It has the following properties:
  - **id** - The unique identifier of the user activity.
  - **userId** - The unique identifier of the user who added the activity.
  - **activityId** - The unique identifier of the activity.
  - **startTime** - The date and time the activity was started.
  - **duration** - The duration of the activity in seconds.
  - **distance** - The distance covered during the activity.
  - **averageHeartRate** - The average heart rate during the activity.
  - **notes** - Additional notes about the activity.

**UserActivity** - Represents a user activity. It has the following properties:
  - **id** - The unique identifier of the user activity.
  - **userId** - The unique identifier of the user who added the activity.
  - **activityId** - The unique identifier of the activity.
  - **startTime** - The date and time the activity was started.
  - **duration** - The duration of the activity in seconds.
  - **distance** - The distance covered during the activity.
  - **averageHeartRate** - The average heart rate during the activity.
  - **notes** - Additional notes about the activity.
  - **caloriesBurned** - The number of calories burned during the activity.
  
## Managing Users

### Model

**NewUser** - Defines a user. It has the following properties:
 - **name** - The name of the user.
 - **weight** - The weight of the user in kilograms.
 - **dateOfBirth** - The date of birth of the user.

**User** - Defines a user. It has the following properties:
 - **id** - The unique identifier of the user.
 - **name** - The name of the user.
 - **weight** - The weight of the user in kilograms.
 - **dateOfBirth** - The date of birth of the user.

### Requirements

- what happens when user is deleted and has activities?
- 


## General Requirements
Each new entity must have a unique identifier, which is generated by the application (as opposed to being provided by the user).
The identifier can be number (for example long) or string (for example UUID).
