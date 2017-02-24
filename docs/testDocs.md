## Test documentation

I have been tryting to implement as wide as possible tests. However there have been some issues with pit coverage due to the rendering of items is very much distributed to many classes. Also there are some limits in testing due to the fact that I'm using very much private class variables without getters and setters, so I dont have any outer access for these variables and they are widely used in the class.

Also because the gameplay is very limited and super simple and there isn't much user input, I consider that the need of tests are very limited because the game is very stable and error proof internally.