Universe 774061 – A project to simulate an alternative universe.

This project contains 7 classes, one of which has not been edited since starting the project (Canvas).
The other 6 classes are used to model the universe. Firstly, Universe: this calls the other classes 
in order to model different aspects of the universe. 

Planet: This class produces objects which orbit a defined star in its constructor. 

Star: This class produces objects which are static and can have more than one planet orbiting it.

Black_Hole: This class produces objects in which when a Space_Object gets too close (radius + 5) 
its direction is changed and it starts moving directly towards the centre of the Black_Hole without it’s ‘special abilities’. 

Space_Object: This is the largest and most complex class in the project. I have modelled Space_Object type 1 and 4.
 These objects can bounce of the side of the universe, when they do their xSpeed & ySpeed is reverse. Additionally,
 Space_Objects can collide with one another. If two Space_Objects of the same type hit they simply bounce off each 
 other. If the two Space_Objects are of different types there are different results for different sizes and speeds. 
 If one is larger than the other, the smaller is destroyed. If speeds are the same, the smallest is removed. If both 
 speed and size are the same both Space_Objects are removed. Also, Space_Objects can collide with a Planet object, when 
 they do their area is added to the planet. They can also collide with Star objects, when this happens the Space_Object 
 area is calculated and added to the lifetime of the star. This class was created by Robert Topp and I have edited it.

Universe: This class simulates a model universe. Dependent on the method called certain objectes will be shown on the screen.

Menu: This class is used as a basic UI. In which users can call a variety of different methods to show different aspects of the universe.

Canvas: 
***To start this project create a Menu object and then call displayMenu(). Or you can create a universe and call a certain method.***

T.CHATE & R.TOPP 2016
