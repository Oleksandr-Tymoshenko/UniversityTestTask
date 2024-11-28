<h1>Simple University App</h1>

___
A simple Spring Boot java project with the console interface for university, which consists of departments and lectors.
The lectors could work in more than one department. A lector could have one degree (assistant, associate professor,
professor).


<p align="center">
  <a href="#features">Additional features</a> |
  <a href="#getting-started">Getting Started</a> |
  <a href="#commands-description">Commands desription</a>
</p>

___

<h2 id="features"> Additional Features</h2>

1. __Checkstyle Plugin__

The project incorporates the Checkstyle plugin to enforce code quality and 
maintain consistency across the codebase. 
This ensures adherence to coding standards, improves 
readability, and minimizes potential issues. 
The plugin can be easily integrated into various development environments, 
making it a valuable tool for maintaining clean code.

2. __Database Migrations with Liquibase__ `(YAML Format)`

Database schema and data migrations are managed using 
Liquibase, leveraging its YAML configuration format for 
simplicity and readability. Liquibase is a cross-platform 
solution that works seamlessly with different database 
systems, allowing smooth and consistent migrations across 
environments. This approach enhances version control for 
database changes and ensures a reliable deployment process.
___

<h2 id="getting-started"> Getting Started</h2>

1. Clone repository
   
```text
git clone https://github.com/Oleksandr-Tymoshenko/UniversityTestTask.git
```

2. Create `.env` file with variables <br>
      Look for variables names in file: `.env.sample`


3. Create the empty database and fill its name into `.env` file. <br>
_After you start the project Liquibase will automatically fill it with values_
___

<h2 id="commands-description"> Commands desription</h2>

1. User Input: `Who is head of department {department_name}` <br>
Answer: Head of {department_name} department is {head_of_department_name}

2. User Input: `Show {department_name} statistics` <br>
Answer: assistans - {assistams_count}. <br>
associate professors - {associate_professors_count} <br>
professors - {professors_count}

3. User Input: `Show the average salary for the department {department_name}` <br>
   Answer: The average salary of {department_name} is {average_salary}

4. User Input: `Show count of employee for {department_name}` <br>
   Answer: {employee_count}

5. User Input: `Global search by {template}`   
   Example: Global search by <strong>van</strong> <br>
   Answer: I<strong>van</strong> Petrenko, Petro I<strong>van</strong>ov
