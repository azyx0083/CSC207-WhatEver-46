# CSC207-WhatEver-46

## Project Domain
We focus on making multiple customizable visualizations of different stocks on the stock market(now focusing on NASDAQ).

## Software Specifications
Our projects support efficient access to real-time stock data, includes data from real-time stock exchanges, especially NASDAQ. We also provides multiple kinds of stock visualization, currently we support traditional tabular view and candlestick graph. We also allow registered users to customize their visualizations.

## API Usage
Twelve Data in RapidAPI (https://rapidapi.com/twelvedata/api/twelve-data1/)
We currently use 3 endpoints
1. Time Series --- access the historical price
2. Real-time Price --- access the real-time price
3. Stock List --- access the detailed information: the name, type and stock market exchange, etc.

## Main Functionality
Two different visualizations:
    * Official CandleStick graph with open, high, low, close
    * Tabular Chart contains stock information
Signup and Login:
    * Allow Users to signup, login
Menu and Search:
    * All kind of users can search for a stock by its symbol
    * Users can choose to signup or login on menu
    * If user already logged in, he will see the setting and log out feature
Options:
    * After search use case succeed, users will be able to choose which visualizations they want
Setting:
    * Only registered users have access to this feature
    * Allow users to choose the interval and output size of the data, their visualizations will change based on their choices

## Designers and Contributors of Each Feature
More specific contributions could be seen in Insights on github(accurate to lines)
Package entity: Amanda
Package data_access: Amanda
Package app: 
  Main: Amanda
  Package factory:
    LoginUseCaseFactory, LogoutUseCaseFactory, SignupUseCaseFactory: Charles
    OptionsUseCaseFactory: OCP applied, designed and implemented by: Charles and Amanda
    MenuUseCaseFactory, SettingsUseCaseFactory: Winston
    SingleStockGraphicalUseCaseFactory, SingleStockTabularUseCaseFactory, SingleStockUseCaseFactory: Amanda

For remaining part we will count contributions by features based on Clean Architecture
Feature SingleStockGraphical visualization:
  interface_adapter, use_case, debugging and design of view: Amanda
  basic framework of view: Andy
Feature SingleStockTabular visualization: Amanda
Feature Setting: Winston
Feature Menu: Winston
Feature Signup and Login: Charles
Feature Logout(only has interface_adapter and use_case):Andy
Feature Search and Options view:
  use_case and view: Charles
  interface_adapter: Winston
Final debugging and optimization:
  Layouts optimization: Amanda
  Bug fixing: Amanda and Charles

UML diagrams: Amanda and Charles

Tests:
  data_access: Amanda
  entity: Amanda
  use_case:
    menu and settings: Winston
    login,logout, search and signup: Charles
    single_stock: Amanda
  bug fixing of tests: Amanda

## Design Patterns, Principles and Clean Architecture applied
We will show the design patterns, SOLID principles and Architecture we applied in our program and its contributors who applied it to our program.
We using Clean Architecture as our overall code framework. Contributors: Amanda, Charles, Winston, Andy
Design Patterns and SOLID principles based on Clean Architecture:
Facade, Factory, Observer, Adapter, DIP.
Other design patterns and SOLID principle in out program:
SRP in the data_access: Amanda
OCP in menuView and SingleStock and Options Feature: Amanda and Charles
LSP and adapter in SingleStock Feature: Amanda
Dependency Injection in SingleStock Feature: Amanda
Facade in Signup Feature: Charles
ISP in Search Feature: Charles

## Further Improvements and Potential Next Step
Since our code allows adding unlimited visualizations without modifying existing code, if we have chance to keep working on this project, we may adding new visualizaitons such as line chart and histograms to allows users to conduct more comprehensive analysis of the stock market.
We also want to add a Favourite Stock List for each registered user, this feature will allow users to keep track on some stocks they interested more.

  
