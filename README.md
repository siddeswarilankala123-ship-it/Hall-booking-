# Online Function Hall Booking

Java 17 + Jakarta Servlet + JSP + JDBC + MySQL + Tomcat 10.1 starter application.

## Requirements
- JDK 17+
- Maven
- MySQL 8+
- Apache Tomcat 10.1+

## Setup
1. Create the database:
   `mysql -u root -p < database/schema.sql`
2. Open `src/main/java/com/functionhall/util/DBConnection.java`
   and set your MySQL username/password.
3. Run:
   `mvn clean package`
4. Copy `target/FunctionHallBooking.war` to Tomcat's `webapps` folder.
5. Start Tomcat.
6. Open:
   `http://localhost:8080/FunctionHallBooking/`

## Demo accounts
After running the SQL:
- Admin: admin@example.com / admin123
- Customer: user@example.com / user123

Change all demo passwords before real deployment.

## Included
- Registration/login/logout
- Password hashing with BCrypt
- Function hall listing
- Hall details
- Date availability check
- Booking creation
- My bookings
- Admin dashboard
- Hall CRUD basics
- JDBC DAO layer
- MySQL schema
