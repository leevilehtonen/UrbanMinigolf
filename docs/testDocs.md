## Test documentation

I have been tryting to implement as wide as possible tests. However there have been some issues with pit coverage due to the rendering of items is very much distributed to many classes. Also there are some limits in testing due to the fact that I'm using very much private class variables without getters and setters, so I dont have any outer access for these variables and they are widely used in the class.

Also because the gameplay is very limited and super simple and there isn't much user input, I consider that the need of tests are very limited because the game is very stable and error proof internally.

### Known issues

Because the game doesn't use any additional librarys for physics collisions, the implementations are very limited. Basically the collisions have been taken out of the main game loop for increased performance. This separate loop is executed as often as possible using timer with zero delay. However even this fast loop isn't enough fast in slower machines, which means the ball might get out of bounds. The bug could have been easily fixed by using for example box2d physics library, but the goal of this project was to create game wihtout any additional libraries.