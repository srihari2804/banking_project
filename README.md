# Hari Bank Project

Simple banking project using Spring Boot REST APIs, PostgreSQL, JWT and React.

## Default Admin

The backend creates/updates this admin when the application starts:

- Username: `admin`
- Email: `admin@gmail.com`
- Password: `admin@123`
- Role: `ADMIN`

The password is stored using BCrypt.

## Admin Flow

Admin can:

- Login using JWT
- View all users
- View customers
- Make a USER into an ADMIN

Public registration always creates a USER.

## Run Backend

Open the `project` folder in Eclipse/STS/IntelliJ and run the Spring Boot application.

Backend: `http://localhost:8080`

## Run Frontend

```bash
cd banking-ui
npm install
npm run dev
```

Frontend normally runs on `http://localhost:5173`.

## Database

PostgreSQL database: `banking_db`

Update `project/src/main/resources/application.properties` with the local PostgreSQL username/password.
