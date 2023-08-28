## A Simple College Data API

#### Built using Java Spring Boot

## Functionality
CREATE, READ, UPDATE nad DELETE records

## Getting Started
Step 1: Clone the repository
```
git clone https://github.com/Humphrey-nyaga/collegemanagement.git
```
Step 2: navigate to the project repository
```
cd $dirName
```

Step 3: Create a MySQL Database in your local instance
Make sure you have MySQL installed.
You can also download MySQL from here [https://dev.mysql.com/downloads/installer/]
```
mysql> CREATE DATABASE student_database;
```

Step 4: cd into the project directory
```
mvn clean install
```
Step 4: Run the project.
The api can be accessed from
```
http://localhost:8080/
```
## Usage Example
Endpoints

| Method   | URL                       | Description                             |
|----------|---------------------------|-----------------------------------------|
| `POST`   | `/api/v1/student/`        | create a new student.                   |
| `GET`    | `/api/v1/student/`        | List all students.                      |
| `GET`    | `/api/v1/student/{id}`    | Retrieve a student with given id.       |
| `DELETE` | `/api/v1/student/delete/{id}` | Delete records of student with given id.|
| `UPDATE` | `/api/v1/student/update/` | Modify records of an existing student.  |


Create a New Student Example
```
POST http://localhost:8080/api/v1/student/
{
"name": "John Doe Smith",
"address": "123 Main St, Anytown, USA",
"major": "Computer Science",
"dob": "1995-01-01",
"email": "johndoe@example.com"
}

``` 

## Project Configuration

| Components        | Technology        | 
   |-------------------|-------------------|
| Backend           | Spring Boot 6.0+, Java 17 | 
| Database          | MySQL             |  
| Server Build      | Maven             |
| API testing       | POSTMAN           |
| Tool              | Intellj Idea      |
   
