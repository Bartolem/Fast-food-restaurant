# Fast-Food Restaurant
The Fast Food Ordering System is a Java-based application that simulates an ordering system for a fast-food restaurant. 

## Table of Contents
* [Introduction](#introduction)
* [Used technologies](#used-technologies)
* [Description](#description)
* [Features](#features)
* [Architecture](#architecture)
* [Getting Started](#getting-started)
* [Usage](#usage)
* [Demo](#demo)
* [License](#license)

## Introduction
Working on this project was a valuable learning experience. I deepened my understanding of object-oriented programming, particularly in designing and organizing code using Java. Developing the graphical user interface with Java Swing provided hands-on experience in creating intuitive and responsive user interfaces. Integrating PostgreSQL for database management enhanced my skills in performing CRUD operations and writing efficient SQL queries. Additionally, implementing the MVC pattern and using Maven for build automation and dependency management improved my software architecture and project management abilities. Writing unit tests with JUnit and using Git for version control further reinforced the importance of testing and version management in software development. Overall, this project has significantly enriched my knowledge and skills across various aspects of software development.

## Used technologies
* Java: The core programming language for the application.
* Swing: Used for building the graphical user interface.
* Maven: For project management and building.
* PostgreSQL: Database for storing customer data, product information, and orders.
* JUnit 5: For unit testing the application's components.

## Description
The system allows customers to view the menu, add products to their orders, apply discounts, manage their accounts, and process orders. The graphical user interface (GUI) is built using Swing, and the application includes features such as customer registration, login, and point management for discounts.

## Features
Customer Management:
* Register new customers
* Login for existing customers
  
Menu Browsing:
* View a variety of product categories including burgers, drinks, sides, and desserts
* Detailed product view with images
  
Order Management:
* Add or remove products from the order
* View total order cost with real-time updates
* Apply discounts based on customer points
  
Order Processing:
* Cancel or process orders
* Points awarded on order completion

Bill Receipt:
* Save bill receipt in the following formats: (file.txt, JSON, PDF, CSV)

## Architecture
The Fast Food Ordering System follows a modular architecture, separating concerns into different packages. The architecture ensures maintainability, scalability, and ease of development.

Packages
1. org.fast_food.bill_receipt:
* BillReceipt.java: Manages the generation and formatting of order receipts.
* BillReceiptPrinter.java: Handles the printing of the order receipts.

2. org.fast_food.customer:
* Customer.java: Represents the customer entity.
* CustomerDAOImpl.java: Implements customer-related database operations.

3. org.fast_food.database_connection:
* DatabaseConnection.java: Manages connections to the PostgreSQL database.

4. org.fast_food.menu:
* Menu.java: Handles the menu-related functionalities.
* NaturalOrderComparator.java: Compares menu items for sorting.

5. org.fast_food.order:
* Order.java: Represents the order entity.
* OrderManagement.java: Manages order processing and operations.

6. org.fast_food.points_manager:
* PointsManager.java: Manages customer points and discounts.

7. org.fast_food.product:
* Product.java: Represents the product entity.
* Type.java: Enum for product types.

8. org.fast_food.user_interface:
* CustomerPanel.java, LoginPage.java, ProcessingOrderPage.java, ProductDetailPage.java, RegistrationForm.java, UserInterface.java: GUI components for various user interactions.
* order_page: Contains subcomponents like CategoryPanel.java, ItemContainer.java, MenuPanel.java, OrderListPanel.java, OrderPage.java, and ProductPanel.java for order management in the UI.

## Getting started

## Usage
1. Launching the Application:
On launch, the login page is displayed. Users can either log in with existing credentials or navigate to the registration form to create a new account.

2. Browsing the Menu:
After logging in, users can browse different categories of the menu using the sidebar. Each category displays a list of products with images, names, and prices.

3. Adding Items to Order:
Users can add items to their order by clicking the "+" button on each product. The quantity can be adjusted using a spinner.

4. Viewing the Order:
The order list panel on the right shows the current order with product names, prices, and quantities. It also displays the total cost.

5. Applying Discounts:
If the user is logged in, they can check for available discounts based on their points. The total price after applying the discount is shown.

6. Processing or Cancelling the Order:
Users can either process the order by clicking the "Pay" button or cancel the order by clicking the "Cancel" button.

## Demo
https://github.com/user-attachments/assets/822883fc-3fbe-4876-b806-fdb33c7ece75

## License
This project is licensed under the MIT License. See the LICENSE file for details.
