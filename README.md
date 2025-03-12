# 🚔 Real-Time Crime Reporting System 🆘


A real-time crime reporting system that enables users to report crimes such as **theft, accidents, and assaults**. The system automatically detects the user's location using the **Google Maps API** and forwards the report to the nearest police station.  

## 🔹 Features  
✅ **User-Friendly Interface** – Simple and efficient crime reporting system  
✅ **Real-Time Location Tracking** – Auto-fetches user location using **Google Maps API**  
✅ **Instant Report Forwarding** – Sends reports to the nearest police station  
✅ **Secure Login System** – Separate access for **users and administrators**  
✅ **Admin Dashboard** – View, verify, and manage crime reports  
✅ **SMS/Email Alerts** – Notify authorities about reported incidents  

---

## 🛠️ Tech Stack  
- **Front-End:** Java Swing (GUI)  
- **Back-End:** Spring Boot, Java  
- **Database:** MySQL  
- **Google Services API:** For real-time location tracking  
- **Security:** Spring Security for authentication  

---

## 📌 How to Run  

### 1️⃣ Clone the repository  
```sh
git clone https://github.com/your-username/crime-reporting-system.git
cd crime-reporting-system
```

### 2️⃣ Set up the database  
- Open **MySQL** and create a database:  
  ```sql
  CREATE DATABASE crime_reports;
  ```
- Update `application.properties` in **Spring Boot** with your database credentials:  
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/crime_reports
  spring.datasource.username=root
  spring.datasource.password=yourpassword
  ```

### 3️⃣ Run the Spring Boot Backend  
```sh
mvn spring-boot:run
```

### 4️⃣ Launch the Java Swing GUI  
- Open `CrimeReportingApp.java` in an **IDE (like IntelliJ or Eclipse)**  
- Run the **main()** method  

### 5️⃣ Start Reporting Crimes! 🚔  

---

## 📜 Visit the Articles  
🔗 **[Get Here](https://www.sciencedirect.com/science/article/pii/S1877050916305646)**  

---

## 💡 Suggestions & Improvements  
Feel free to suggest improvements or contribute to the project! 🚀  

---


**Thanks a lot,**  
**Satyabrata Das**  
*Project Leader*
