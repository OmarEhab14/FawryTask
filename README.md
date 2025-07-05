# 🛒 Fawry E-Commerce System

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![OOP](https://img.shields.io/badge/OOP-SOLID%20Principles-green)

A clean Java implementation of an e-commerce system fulfilling Fawry's internship requirements.

## 🏗️ Project Structure
```
src/
├── Main.java
├── interfaces/
│   ├── Expirable.java
│   ├── Shippable.java
│   └── ShippingService.java
├── models/
│   ├── BasicProduct.java
│   ├── Cart.java
│   ├── CartItem.java
│   ├── Customer.java
│   ├── ExpirableProduct.java
│   ├── ExpirableShippableProduct.java
│   ├── Product.java
│   └── ShippableProduct.java
└── services/
    ├── Checkout.java
    └── ProductShippingService.java
```

## ✨ Core Features

- **Product Hierarchy**:
  - `Product` (abstract base class)
  - `Expirable` products with expiration dates
  - `Shippable` products with weight
  - Combined `ExpirableShippable` products

- **Shopping Flow**:
  - Cart management with quantity validation
  - Automatic stock/expiration checks
  - Shipping fee calculation
  - Checkout processing

- **Error Handling**:
  - Empty cart prevention
  - Insufficient balance
  - Out-of-stock items
  - Expired products

## 📦 Key Components

| Class/Interface          | Description                          |
|--------------------------|--------------------------------------|
| `Product`                | Abstract base product                |
| `Expirable`              | Marks expirable products             |
| `Shippable`              | Marks shippable products             |
| `Cart`                   | Manages customer selections          |
| `Checkout`               | Processes payments                   |
| `ShippingService`        | Handles shipping logic               |

## 🛠️ Technical Highlights

- **Clean OOP Design**:
  - Proper inheritance (`Product` → `ExpirableProduct`)
  - Interface segregation (`Expirable`, `Shippable`)
  - Composition over inheritance

- **SOLID Principles**:
  - Single Responsibility (each class has one purpose)
  - Open/Closed (extensible without modification)
  - Liskov Substitution (proper inheritance)
  - Interface Segregation
  - Dependency Inversion

## 💻 How to Run

1. Compile all Java files:
```bash
javac *.java
```
2. Execute the main class:
```bash
java Main
```
