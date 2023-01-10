# Project Title

Connect 4 game

## Description

This program replicates the Connect Four game in the console. The game has numerous options which include saving the game at each turn or loading a saved game
in the beginning. When the game begins there will be two players with their respective chips, one player with X chips and the other with
O chips. The board will update after each turn and keep track of which players turn it is. To win the game a player must have 
4 of their chips in a row, this can be acomplished by having 4 vertical chips, 4 horizontal chips, and 4 diagonal chips in any direction. When 
there is a winner the program will output which player won and exit the program. There can also be ties, if the board is completely full with chips and 
there is no combination of any 4 equal chips in a row then their will be an output of a tie and the program will exit. Some important things to note include that loading and
saving a file will be through a .csv file. Other than that enjoy the game. 

## Getting Started

### Dependencies

No dependecies.

### Executing program

Once the files from this repository are downloaded or cloned please follow the steps to compile the program:

1. Firstly, build the program with gradle using the command:
``` gradle build ```
2. Once the program is build successfully execute the gradle run command as such: 
``` gradle run ```
3. After this is completed you should see the command to run the program it should look as follows:
``` 
java -cp build/classes/java/main connectfour.ConnectFour 
copy and paste this line above in the terminal to run Connect 4
```
The expected output should be: 

```
Would you like to load an existing game? (y or n)
```
## Limitations

To my knowledge things that are not completed are re-prompting the user when the file they want to save
is invalid. This is not incorrect but would be useful in the program flow and functionality.

## Author Information

Sebastian Mollejas
1150663
smolleja@uoguelph.ca

## Development History

History was done through Git comments.

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [simple-readme] (https://gist.githubusercontent.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc/raw/d59043abbb123089ad6602aba571121b71d91d7f/README-Template.md)



