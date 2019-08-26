# Movies-challenge

<br>The architecture was made with concepts of "Clean Architecture", feature-oriented. It has horizontality to create modules for every feature and increases reusability.
<br>The [app] module takes care of the navigation between features and is responsible for "Dependency Injection".
<br>[common] its meant to be used for snippets of code that will be common in several places; Layouts, "View Models" and even repository contracts.
<br>The [data] module has the implementation of every repository contract, it's the only module with the responsibility to make calls on web servers or DBs.
<br>[home] its the first feature module, it has the implementation of layouts, behaviors, and animations, accessing the [data] when needed for retrieve data. Through the development, several modules like that will be created, one for each application's flow. 

Instructions:
Run the application, selecting the flavor [Integration] and pressing [Run] after the gradle sync, this is going to build the application using the implementation that targets the web service.

Important points:
<br>.Modularization
<br>.Gradle Templates
<br>.Flavors
<br>.Code reusability
<br>.Dependency Injection
<br>.Offline mode after first sync
<br>.Room, Retrofit, LiveData

What's next?
<br>.Placeholder for images.
<br>.Custom message at the end of the pages (500 pages).
<br>.Better handle some orientation changes (layout and async tasks)
<br>.Finish the tests on [data] module (Reach test coverage above 80%)
<br>.Create instrumental tests
<br>.Mock the "Retrofit Call" object on [Mock] flavor, to run the application entirely offline and, with controlled data.
<br>.Map DTO response to a better-formed object for the presentation layer.
