-- Create table for patients
CREATE TABLE IF NOT EXISTS patient
(
    id UUID PRIMARY KEY,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    birthDate DATE NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(20) NOT NULL,
    registrationDate DATE NOT NULL
);

-- Insert 10 Nepali patient records
INSERT INTO patient (id, firstName, lastName, email, birthDate, age, gender, address, phoneNumber, registrationDate)
SELECT '123e4567-e89b-12d3-a456-426614175001',
       'Sita', 'Shrestha', 'sita.shrestha@example.com', '1990-01-15', 34, 'Female', 'Kathmandu, Nepal', '9812345678', '2024-03-01'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614175001');

INSERT INTO patient (id, firstName, lastName, email, birthDate, age, gender, address, phoneNumber, registrationDate)
SELECT '123e4567-e89b-12d3-a456-426614175002',
       'Ram', 'Khadka', 'ram.khadka@example.com', '1985-06-20', 38, 'Male', 'Pokhara, Nepal', '9801234567', '2023-12-15'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614175002');

INSERT INTO patient (id, firstName, lastName, email, birthDate, age, gender, address, phoneNumber, registrationDate)
SELECT '123e4567-e89b-12d3-a456-426614175003',
       'Gita', 'Basnet', 'gita.basnet@example.com', '1992-11-08', 32, 'Female', 'Biratnagar, Nepal', '9845671230', '2024-01-10'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614175003');

INSERT INTO patient (id, firstName, lastName, email, birthDate, age, gender, address, phoneNumber, registrationDate)
SELECT '123e4567-e89b-12d3-a456-426614175004',
       'Bikash', 'Thapa', 'bikash.thapa@example.com', '1988-03-12', 36, 'Male', 'Butwal, Nepal', '9865432109', '2023-10-05'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614175004');

INSERT INTO patient (id, firstName, lastName, email, birthDate, age, gender, address, phoneNumber, registrationDate)
SELECT '123e4567-e89b-12d3-a456-426614175005',
       'Anita', 'Rai', 'anita.rai@example.com', '1994-07-25', 30, 'Female', 'Dharan, Nepal', '9804567891', '2024-02-20'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614175005');

INSERT INTO patient (id, firstName, lastName, email, birthDate, age, gender, address, phoneNumber, registrationDate)
SELECT '123e4567-e89b-12d3-a456-426614175006',
       'Kiran', 'Gurung', 'kiran.gurung@example.com', '1982-09-18', 42, 'Male', 'Lalitpur, Nepal', '9812233445', '2023-06-01'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614175006');

INSERT INTO patient (id, firstName, lastName, email, birthDate, age, gender, address, phoneNumber, registrationDate)
SELECT '123e4567-e89b-12d3-a456-426614175007',
       'Mina', 'Magar', 'mina.magar@example.com', '1996-04-30', 28, 'Female', 'Chitwan, Nepal', '9823456789', '2024-01-25'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614175007');

INSERT INTO patient (id, firstName, lastName, email, birthDate, age, gender, address, phoneNumber, registrationDate)
SELECT '123e4567-e89b-12d3-a456-426614175008',
       'Dipak', 'Adhikari', 'dipak.adhikari@example.com', '1991-12-10', 33, 'Male', 'Hetauda, Nepal', '9809988776', '2023-11-11'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614175008');

INSERT INTO patient (id, firstName, lastName, email, birthDate, age, gender, address, phoneNumber, registrationDate)
SELECT '123e4567-e89b-12d3-a456-426614175009',
       'Rupa', 'Tamang', 'rupa.tamang@example.com', '1998-08-22', 26, 'Female', 'Janakpur, Nepal', '9811223344', '2024-03-03'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614175009');

INSERT INTO patient (id, firstName, lastName, email, birthDate, age, gender, address, phoneNumber, registrationDate)
SELECT '123e4567-e89b-12d3-a456-426614175010',
       'Sunil', 'Acharya', 'sunil.acharya@example.com', '1980-05-05', 44, 'Male', 'Nepalgunj, Nepal', '9841234560', '2023-12-20'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614175010');
