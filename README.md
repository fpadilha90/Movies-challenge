# Movies-challenge

The architecture was made with concepts of "Clean Architecture", feature-oriented. It has horizontality to create modules for every feature and increases reusability.
The [app] module takes care of the navigation between features and is responsible for "Dependency Injection".
[common] its meant to be used for snippets of code that will be common in several places; Layouts, "View Models" and even repository contracts.
The [data] module has the implementation of every repository contract, it's the only module with the responsibility to make calls on web servers or DBs.
[home] its the first feature module, it has the implementation of layouts, behaviors, and animations, accessing the [data] when needed for retrieve data. Through the development, several modules like that will be created, one for each application's flow. 

Instructions:
Run the application, selecting the flavor [Integration] and pressing [Run] after the gradle sync, this is going to build the application using the implementation that targets the web service.

Important points:
.Modularization
.Gradle Templates
.Flavors
.Code reusability
.Dependency Injection
.Offline mode after first sync
.Room, Retrofit, LiveData

What's next?
.Finish the tests on [data] module (Reach test coverage above 80%)
.Create instrumental tests
.Mock the "Retrofit Call" object on [Mock] flavor, to run the application entirely offline and, with controlled data.
.Map DTO response to a better-formed object for the presentation layer.
.Review the layout for best user usability.
