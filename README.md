# CSC207-WhatEver-46

## Project Domain
We focus on making multiple customizable visualizations of different stocks on the stock market.

## Software Specifications
Our projects should  
1. support efficient access to real-time stock data, includes data from real-time stock exchanges, especially NASDAQ
2. provides multiple kinds of stock visualization, especially traditional tabular view and candlestick graph
3. allow some level of customization after registered
4. help analyzing and visualizing stock data efficiently

## API Usage
Twelve Data in RapidAPI (https://rapidapi.com/twelvedata/api/twelve-data1/)

We currently use 3 endpoints
1. **Time Series** --- access the historical price
2. **Real-time Price** --- access the real-time price
3. **Stock List** --- access the detailed information: the name, type, stock market exchange, etc.

## Current Functionality
### Menu and Search
   * All kind of users can search for a stock by its symbol
   * Popup should automatically appear if the symbol is invalid or exceed the per minute limit
   * Users can choose to signup or login on menu
   * If user already logged in, he will see the setting and log out feature

### Options
   * After search use case succeed, users will be able to choose which visualizations they want

### Visualization of a single stock data (currently only support two)
   * Official CandleStick graph with open, high, low, close prices and volume
   * Tabular Chart contains stock information

### Signup and Login
   * Allow Users to signup, login and access the customization features

### Setting
   * Only registered users have access to this feature
   * Allow users to choose the interval and output size of the data, their visualizations will change based on their choices
     * **Interval** – the time interval between each historical price
     * **Output size** – the number of historical price 
     * A default setting with **30** outputs and **per day** interval

## Structure and Packaging
All follows clean architecture. Each layer in the clean architecture has its own package. Within each package, all usecase also has separate package.

## Design Patterns and SOLID Principle
### Single Responsibility Principle
* the use of two separate DataAccessObject to manage user relates data and API related data

**Contributor**: Amanda

### Open-closed Principle
* the use of map as parameter instead of hard coding each controller and buttons in factory and view
* open to new visualization
* close to modification on existing factories and views

**Contributor**: Charles, Amanda

### Liskov substitution Principle
* all subclasses of SingleStockPriceData interface share the same property
    * store historical data of a stock
    * can be updated by the presenter

**Contributor**: Amanda

### Interface Segregation Principle

### Dependency Inversion Principle
* the use of interface between interactor and presenter, interactor and data access object

**Contributor**: Winston, Charles, Andy, Amanda

### Adapter
* subclasses of SingleStockPriceData interface
* inherit methods from existing class to support visualization and component generation
* implement the updateData() to allow update in SingleStockPresenter

**Contributor**: Amanda, Charles

### Dependency Injection
* subclasses of SingleStockViewModel construct the corresponding subclass of SingleStockPriceData first, then use it to construct the SingleStockState
* no hard dependency between SingleStockState and SingleStockPriceData
* any subclasses of SingleStockState are allowed in SingleStockState
* fully reusable SingleStockState for all visualization

**Contributor**: Amanda

### Factory
* the use of different factories in app package to construct different views and controllers
* the use fo UserFactory in entity package to construct a registered user or a default user

**Contributor**: Winston, Charles, Andy, Amanda

### Observer
* the use of viewModel and state to trigger and refresh corresponding view

**Contributor**: Winston, Charles, Andy, Amanda

### Facade

## Tasks and Duties
### Minimum Viable Product
1. Stock and HistoricalPrice (entity) - Amanda
2. APIDataAccessObject - Amanda
3. Menu usecase - Winston
4. Search usecase - Charles & Andy
5. SingleStock usecase - Amanda

**Deadline**: Nov 19, 2023 

### First Bug Fixing
1. Main and factories
2. Debug and testing
3. Documentation and naming convention 
4. Refine view layout

**Contributor**: Winston, Charles, Andy, Amanda

**Deadline**: Nov 22, 2023

### Additional Features
1. Login usecase - Charles
2. Signup usecase - Charles
3. Logout usecase - Andy
4. Setting usecase - Winston
5. FileUserDataAccess - Amanda
6. User and UserSetting (entity) - Winston

**Deadline**: Dec 1, 2023

### Second Bug Fixing
1. Bridge different usecase
2. Minor changes in the minimum viable product to support new features
3. Debug and testing
4. Documentation and naming convention
5. Refine view layout

**Contributor**: Winston, Charles, Andy, Amanda

**Deadline**: Dec 3, 2023

## Further Improvements and Potential Next Step
### New visualizations
  * line chart
  * histogram
  * ....
### More precise setting features to increase efficiency and support wider range of customization
  * a list of favourite stock
  * ....

  
