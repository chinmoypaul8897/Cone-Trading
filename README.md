
# Cone Trading - Crypto Trading Platform

## Overview

Cone Trading is a comprehensive cryptocurrency trading platform that allows users to manage their portfolios, perform buy/sell transactions, recharge wallets, and withdraw funds to their bank accounts. The platform integrates with payment gateways like Razorpay and Stripe and incorporates live data from the CoinGecko API. Users can track the top 50 cryptocurrencies, monitor their balances, watch transaction details, and manage their assets in real-time.

This platform is developed using Spring Boot, Spring Security, and MySQL for the backend, with integrated services for handling user authentication, portfolio management, payments, and more.

## Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Project](#running-the-project)

## Features

### 1. **User Authentication and Authorization**
   - User Sign-up, Login, and Profile Management
   - Two-factor authentication (2FA) for enhanced security
   - JWT-based authentication for secure API access
   - Password reset functionality with OTP verification

### 2. **Cryptocurrency Management**
   - Ability to buy and sell cryptocurrencies via integration with the CoinGecko API
   - Real-time tracking of cryptocurrency prices
   - Viewing top 50 trending cryptocurrencies
   - Ability to add/remove cryptocurrencies to/from the user's portfolio

### 3. **User Portfolio Management**
   - Users can manage their personal cryptocurrency portfolio
   - Display current balance of cryptocurrencies in the user's wallet
   - Users can recharge their wallets via Razorpay and Stripe integrations
   - Ability to withdraw funds from the wallet to the user's bank account
   - View withdrawal details in the personal account

### 4. **Payment Integration**
   - Integration with Razorpay and Stripe for seamless wallet recharge and withdrawal processes
   - Supports fund transfers between user wallets and bank accounts
   - Track payment and withdrawal transactions in real-time

### 5. **Watchlist**
   - Ability to create a watchlist of cryptocurrencies to track
   - Add/remove coins from the watchlist for personalized tracking

### 6. **Transaction History**
   - Track buy/sell transactions in the portfolio
   - Monitor withdrawal and payment details in real-time

### 7. **Asset Management**
   - Full asset management functionality for users to track all holdings
   - Detailed asset breakdown for each cryptocurrency held in the user's portfolio

---

## Technology Stack

- **Backend**: Java 17, Spring Boot, Spring Security, Spring Data JPA
- **Database**: MySQL
- **Payment Gateways**: Razorpay, Stripe
- **Cryptocurrency API**: CoinGecko API
- **Security**: JWT Authentication, Two-Factor Authentication
- **Other**: Maven, Lombok, JJWT for JWT creation

---

## Prerequisites

Before running this project, make sure you have the following installed:

1. **Java 17** or higher
2. **MySQL 8** or higher
3. **Maven** for building the project

---

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/chinmoypaul8897/Cone-Trading.git
   ```

2. Set up the database:
   - Create a MySQL database named `cone_trading`.
   - Update the `application.properties` file with your MySQL credentials:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/cone_trading
     spring.datasource.username=your_db_username
     spring.datasource.password=your_db_password
     spring.jpa.hibernate.ddl-auto=update
     ```

3. Install the project dependencies using Maven:

   ```bash
   mvn clean install
   ```

---

## Running the Project

Start the application using the following command:

```bash
mvn spring-boot:run
```

The backend will be accessible at `http://localhost:8080`.

---
Feel free to reach out for any questions or further clarifications.
