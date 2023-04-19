
# AttendEase



## Abstract
This project report describes the development of an attendance register Android application for use in schools or other educational institutions. The application is designed to simplify the process of recording student attendance, allowing teachers to easily mark and track attendance on their mobile devices. The report covers the entire software development process, including requirements gathering, design, implementation, testing, and deployment. The application is built using Java programming language and Android Studio Integrated Development Environment (IDE), and utilizes Firebase Realtime Database to store attendance data. The app features a simple user interface, and supports multiple user roles including students, teachers, and administrators. The report concludes with an evaluation of the application's functionality and a discussion of potential future enhancements.
## Software Requirements
The software requirements for this Android application are as follows:

Operating System: 
    The application is designed to run on Android operating system version 5.0 (Lollipop) or higher.

Development Environment: 
    The application is developed using Android Studio Integrated Development Environment (IDE) version 4.1 or higher.

Programming Language: 
    The application is developed using Java programming language version 8 or higher.

Database Management System:
    The application utilizes Firebase Realtime Database as the database management system for storing attendance records.

Authentication and Authorization:
    The application uses Firebase Authentication to provide secure authentication and authorization for users.

User Interface Design: 
    The application has a user-friendly and intuitive interface that allows users to easily mark attendance, view attendance records, and access other features of the application.

Overall, the software requirements for this Android application are designed to ensure that the application is scalable, secure, performant, and user-friendly.

## Methodology
The methodology used for the development of this Android application involved several stages, including requirements gathering, design, implementation, testing, and deployment. The following is a detailed explanation of each stage:

Requirements Gathering: 
    In this stage, the project team identified the requirements of the application by conducting surveys with professors and senior students. The key requirements identified include the ability to mark and track attendance, support for multiple user roles, integration with Firebase Realtime Database, and a simple user interface.

Design: 
    Based on the requirements gathered, the project team created a detailed design for the application, including the user interface design, database schema design, and system architecture. The user interface design focused on creating a simple and intuitive interface that would enable easy navigation and usage. The database schema design focused on creating a database structure that would store attendance data efficiently, while the system architecture focused on ensuring scalability, security, and performance.

Implementation: 
    In this stage, the project team implemented the design by writing the application code using Java programming language and Android Studio IDE. The application code was developed in a modular and reusable manner, adhering to the best practices of software engineering.

Testing: 
    The application was tested using a variety of techniques, including unit testing, integration testing, and user acceptance testing. The tests were designed to ensure that the application met the functional and non-functional requirements, and that it was free from errors and bugs.

Deployment: 
    Once the application passed all the tests, it was deployed to the Hostinger, making it available for download and use by the end-users.
    
Overall, the methodology used for the development of this Android application was iterative and incremental, with each stage building on the previous one. 

## Working Walkthrough
This Android application is designed to simplify the process of recording student attendance, allowing teachers to easily mark and track attendance on their mobile devices. The following is a walkthrough of how the application works:

User Login: 
    The user logs in to the application using their registered email address and password. The application verifies the user's credentials and grants access based on their role. The application supports three user roles: student, teacher, and administrator.
    
Home Screen: 
    Upon successful login, the user is presented with the home screen. The home screen displays the user's name and role, as well as the options to mark attendance or view attendance records. The home screen also includes a navigation menu that allows the user to access other features of the application.

Mark Attendance: 
    To mark attendance, the teacher selects the appropriate class from the list of classes they teach. The teacher can then view the list of students in the class and mark their attendance by selecting the appropriate option (present, absent, or late).

Notifications: 
    The application sends notifications to users based on their role and attendance status. For example, if a student is marked absent, the application sends a notification to the parent or guardian, informing them of the absence.

Firebase Realtime Database: 
    The attendance records are stored in Firebase Realtime Database, which allows for real-time synchronization and access to data across different devices and platforms. This feature ensures that the attendance records are accurate and up-to-date.
    
In summary, this Android application simplifies the process of recording student attendance and provides a user-friendly interface for teachers, students, and administrators. The application is designed to be scalable, secure, and performant, utilizing Firebase Realtime Database to store attendance data and providing notifications and reporting features to users.

## Advantages
This Android application offers several advantages, including:

Efficient Attendance Management: 
    The application simplifies the process of recording and managing student attendance, allowing teachers to mark attendance quickly and accurately on their mobile devices.

Real-time Synchronization: 
    The application utilizes Firebase Realtime Database, which allows for real-time synchronization of attendance records across different devices and platforms. This feature ensures that attendance records are always up-to-date and accurate.

Customizable User Roles: 
    The application supports three user roles: student, teacher, and administrator, allowing for customized access and control of attendance records.

Overall, this Android application offers a convenient and efficient way to manage student attendance, improve communication between teachers, students, and parents/guardians, and provide reporting and analytics features for administrators.

## Limitations
The limitations for this Android application may include:

Device Compatibility: 
    The application may not be compatible with older Android devices, limiting its availability and accessibility.
    
Cost:
    The application may require a subscription fee or incur other costs related to data storage and maintenance, which may be a limitation for some educational institutions.

Student Roles Limitations: 
    Currently the application supports two user roles, which are administrator and staff. The student role option is under development.

Overall, this Android application has limitations that must be considered and addressed to ensure its successful implementation and adoption.

## References

[Android Studio Documentation](https://developer.android.com/docs)

[Firebase Documentation](https://firebase.google.com/docs)

[Google Material Design Guidelines](https://material.io/design)
