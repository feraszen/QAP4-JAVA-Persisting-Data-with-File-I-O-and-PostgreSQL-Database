**QAP 4 – Advanced Java: Persisting Data with File I/O and PostgreSQL Database**

---

## 📌 **Project Description**

This project demonstrates two essential Java persistence techniques:

1. **File I/O** — Writing and reading Drug objects to/from a text file.  
2. **Database Persistence (PostgreSQL + JDBC)** — Saving and retrieving Patient objects using a PostgreSQL database.

The application provides a **menu-driven interface** that allows the user to:

- Save Drug data to a text file  
- Read Drug data from the text file  
- Save Patient data to a PostgreSQL database  
- Read Patient data from the database  

This project fulfills all requirements of **QAP 4 – Advanced Java**, including entity classes, file handling, JDBC database operations, and a scanner-based menu.

---

## 🧱 **Features Implemented**

### ✔ **Entity Classes**
- **Drug** → `drugId`, `drugName`, `drugCost`, `dosage`  
- **Patient** → `patientId`, `patientFirstName`, `patientLastName`, `patientDOB`

### ✔ **File I/O**
- Save Drug objects to a text file  
- Read all Drug objects from the file and display them  

### ✔ **Database I/O (PostgreSQL + JDBC)**
- Connect to PostgreSQL using JDBC  
- Insert Patient objects into the database  
- Retrieve and display all patients  
- Custom table created in pgAdmin  

### ✔ **Scanner Menu**
```
1. Save Drug to File
2. Read Drugs from File
3. Save Patient to Database
4. Read Patients from Database
5. Exit
```

---

## 🗄️ **Database Table (patients.sql)**

Below is the SQL script used to create the `patients` table:

```sql
CREATE TABLE patients (
    patient_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    dob VARCHAR(20)
);
```

---

## 📂 **Project Structure**

```
src/
 └── main/
      └── java/
           ├── Drug.java
           ├── Patient.java
           ├── FileHandler.java
           ├── DatabaseHandler.java
           └── Main.java
      └── resources/
           └── db.properties
```

---

## 🖼️ **Screenshots Included**
Your submission includes screenshots showing:

- Saving Drug data to a file  
- Reading Drug data from the file  
- Saving Patient data to PostgreSQL  
- Reading Patient data from PostgreSQL  
- Successful JDBC connection  
- Successful SQL execution in pgAdmin  

---

## 🎥 **Demo Video**
A short video demonstrating:

- File save  
- File read  
- Database save  
- Database read  

(Upload to GitHub or Teams)

---

## 🧪 **How to Run the Project**

### **1. Clone the repository**
```
git clone (https://github.com/feraszen/QAP4-JAVA-Persisting-Data-with-File-I-O-and-PostgreSQL-Database.git) 
```

### **2. Configure PostgreSQL**
Update `db.properties`:

```
db.url=jdbc:postgresql://localhost:5432/qap4db
db.user=postgres
db.password=Feras@2026
```

### **3. Run the project**
```
mvn exec:java
```

---

## 📝 **Assessment Questions (Required by QAP Instructions)**

### **How many hours did it take you to complete this assessment?**
Approx. **3.5 hours**  
(Breakdown: File I/O ~ 1 hour, Database ~ 1.5 hours, Debugging ~ 1 hour)

### **What online resources did you use?**
- Java documentation  
- PostgreSQL documentation  
- StackOverflow  
- Class lectures  

### **Did you get help from any classmates?**
No.

### **Did you ask for help from an instructor?**
No.

### **Rate the difficulty of each problem and your confidence level**
- File I/O: Easy → High confidence  
- Database JDBC: Medium → High confidence  
- Menu system: Easy → High confidence  

---

## ⭐ **Summary**

This project helped reinforce key Java persistence concepts, including file handling and JDBC database operations. It also provided hands-on experience with PostgreSQL, SQL table creation, and menu-driven program design.

All requirements of QAP 4 have been fully implemented and tested.
