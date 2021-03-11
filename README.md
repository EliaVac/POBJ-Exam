# POBJ-Exam

Exam project for the object programming course.

## Table of contents

* [Introduction](#Introduction)

* [App working](#App-working)

* [Filter](#FIlter)

* [Java implementation](#Java-implementation)

* [Strengths](#Strengths)

* [Authors](#Authors)

## Introduction

This application is aimed to show data and statistics on domains that allows to rent houses. The application gives to the user six different roots that allow to satisfy all the possible requests. There are implemented three JUnit test and the Javadoc Documentation, respectively for trial of the filter conversion and for shorts descriptions of the methods and the attributes.

## App working
The user use case diagram shows the three possible work zones and the possible operations available for the user:
![UserUseCaseDiagram](./UmlDiagram/NewModelUserUseCaseDiagram.jpg)

| Root | Type | what does it return |
|---|---|---|
| /getkeywords | GET |The root where you can see the keywords
| /getfilters | GET |The root where you can see the filters of the app
| /getdatabase | GET |The root that permits to have the database
| /getdatabase | POST |The root that permits to have the filtered database
| /getstats | GET |The root that permits to have the statistics
| /getstats | POST |The root that permits to have the filtered statistics collection

The system case diagram shows the different operations to do first and during the execution for all work zones:
![SystemUseCaseDiagram](./UmlDiagram/NewModelSystemCaseDiagram.jpg)

An example of initializing of the application and later the request sequance of the key-words, the possible filters that the user can use, the complete database and the statistics about "all-bounded-zones":
![SequenceDiagram](./UmlDiagram/NewModelSequenceDiagram.jpg)

If we want take the case of a request of a filtered database, instead we got a different sequence diagram:
![SequenceDiagram2](./UmlDiagram/NewModelSequenceDiagram2.jpg)

Similarly, for a filtered statistic collection, or a static collection about specified zones, the sequence diagram:
![SequenceDiagram3](./UmlDiagram/NewModelSequenceDiagram3.jpg)

## Filter
First of all we need to specify that there are two different types of filter: one for the database of domain, the other for the statistic collection.
The first one accept this fields:
| Field | Type | About it |
|---------|-------------------|------|
| country | String of 2 char | identify the countrycode of the country requested |
| minimum_createtime | Object DateTime | identify the lower extreme date for the filtered database|
| maximum_createtime | Object DateTime | identify the upper extreme date for the filtered database|
| minimum_updatetime | Object DateTime | identify the lower extreme date for the filtered database|
| maximum_updatetime | Object DateTime | identify the upper extreme date for the filtered database|
|isdead | boolean | identify if the requested domain are still alive (if false) or are dead (true)|


An example of right filter:
```
[
  {
    "country":"US",
    "minimum_createtime":{
      "year":2018,
      "month":7,
      "day": 24,
      "hour":14,
      "minute":7
    },
    "maximum_createtime":{
    },
    "minimum_updatetime":{
      "year":2018,
      "month":7,
      "day": 24
    }, 
    "maximum_updatetime":{   
      "hour":14,
      "minute":7
    },
    "isdead": "true"
  }		      
]
```


The filter for the statistic collection accept this fields:
| Field | Type | About it |
|---------|-------------------|------|
| zone | String of 2 char | identify the countrycode of the country requested |
| minimum_datetime | Object DateTime | identify the lower extreme date for the filtered statistics collection|
| maximum_datetime | Object DateTime | identify the upper extreme date for the filtered statistics collection|
| increment | Object minimum-maximum | identify the range value of the field increment for the filtered statistics collection|
| decrement | Object minimum-maximum | identify the range value of the field decrement for the filtered statistics collection|
| total | Object minimum-maximum | identify the range value of the field total for the filtered statistics collection|

An example of right filter:
```
[
  {
    "zone":"IT",
    "minimum_date":{
      "year":2020,
      "month":6,
      "day": 1,
      "hour":0,
      "minute":0
    },
    "maximum_date":{
      "year":2021,
      "month":5,
      "day": 30,
      "hour":23,
      "minute":59
    },
    "increment":{
      "minimum":20,
      "maximum":25,
    },
    "decrement":{
      "minimum":35,
      "maximum":45,
    },
    "total":{
      "minimum":37,
      "maximum":67,
    }
  }		      
]

```

The DateTime object has to be written as:

```
{
  "year": intvalue,         (if not setted the applications take the currently year)
  "month": intvalue,        (if not setted the applications take the currently month)
  "day": intvalue,          (if not setted the applications take the currently day of month)
  "hour": intvalue,         (if not setted the application take the hour 00)
  "minute": intvalue        (if not setted the application take the minute) 
}
```

The minimum-maximum object has to be written as:
```
{
  "minimum": intvalue,      (if not setted the application take 0)
  "maximum": intvalue       (if not setted the application take tha maximum value for the class Integer: 2147483647)
}
```

## Java implementation
The package Controller:

![PackageController](./UmlDiagram/PackageController.JPG)

The package Service:

![PackageService](./UmlDiagram/PackageService.JPG)

The package SingleDataClasses:

![PackageSingleDataClasses](./UmlDiagram/PackageSingleDataClasses.JPG)


The package Utilities:

![PackageUtilities](./UmlDiagram/PackageUtilities.JPG)

The package Errors:

![PackageErrors](./UmlDiagram/PackageErrors.JPG)


The package FiltersManagement:

![PackageFiltersManagement](./UmlDiagram/PackageFiltersManagement.JPG)


## Strengths
This application provides to satisfy research about rent house domains. The first technology used is Spring-boot, usefull to interface with the user. All the operations are provided first by the controller, then by the class AppService. The last one is the class that manage all the different request. To minimize the serving time the AppService class saves the possible key-words, the possible filters, the complete database and the general statistics. Whenever the user request a filtered database it's necessary apply the filtering technique thanks to the extension of the class AllOperations. This class is used by StatisticApply too, class for the management of the filter for the statistic collection. So, AllOperations is the real filtering class used by different type. Another strength of this application is the use of the ArrayList for collection of variable dimension. The last but not least strength is the implementation of the exceptions handler with the obiective of a better feedback usefull for a quickly and easier understanding.


## Authors

We are two students of the politecnicnal university of Marche

- ### Federico Di Tullio
- ### Elia Vaccarini


