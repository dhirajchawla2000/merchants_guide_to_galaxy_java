#Merchants Guide to Galaxy

##Problem Statement

You decided to give up on earth after the latest financial collapse left 99.99% of the earth's population with 0.01% of the wealth. Luckily, with the scant sum of money that is left in your account, you are able to afford to rent a spaceship, leave earth, and fly all over the galaxy to sell common metals and dirt (which apparently is worth a lot).
Buying and selling over the galaxy requires you to convert numbers and units, and you decided to write a program to help you.
The numbers used for intergalactic transactions follows similar convention to the roman numerals and you have painstakingly collected the appropriate translation between them.

Roman numerals are based on seven symbols:

|Symbol| Value|
|------|------|
|I     |1     |
|V     |5     |
|X     |10    |
|L     |50    |
|C     |100   |
|D     |500   |
|M     |1,000 |

Numbers are formed by combining symbols together and adding the values. For example, MMVI is 1000 + 1000 + 5 + 1 = 2006. Generally, symbols are placed in order of value, starting with the largest values. When smaller values precede larger values, the smaller values are subtracted from the larger values, and the result is added to the total. For example MCMXLIV = 1000 + (1000 − 100) + (50 − 10) + (5 − 1) = 1944.

The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.) "D", "L", and "V" can never be repeated.
"I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted.
Only one small-value symbol may be subtracted from any large-value symbol.
A number written in [16]Arabic numerals can be broken into digits. For example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be treated separately. Inthe above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.
(Source: Wikipedia ( [17]http://en.wikipedia.org/wiki/Roman_numerals)

Input to your program consists of lines of text detailing your notes on the conversion between intergalactic units and roman numerals.

You are expected to handle invalid queries appropriately.

#####Test input:
```
glob is I
prok is V
pish is X
tegj is L
glob glob Silver is 34 Credits
glob prok Gold is 57800 Credits
pish pish Iron is 3910 Credits
how much is pish tegj glob glob ?
how many Credits is glob prok Silver ?
how many Credits is glob prok Gold ?
how many Credits is glob prok Iron ?
how much wood could a woodchuck chuck if a woodchuck could chuck wood ?
```

#####Test Output:
```
pish tegj glob glob is 42
glob prok Silver is 68 Credits
glob prok Gold is 57800 Credits
glob prok Iron is 782 Credits
I have no idea what you are talking about
```

##Implementation Details

####Introduction

The problem statement I have selected here is Merchants Guide to Galaxy, wherein I need to develop a guide that would allow me to convert (translate) numbers and units while selling stuff in other galaxies. For this problem statement I have used Java as the programming language to develop the code and write test cases. I have tried to use TDD methodology for the development of the code.

####Design

Below mentioned is the design that I have used to develop the code for the selected problem statement:
- To solve this problem I have used the Command Pattern to design the solution.
- There are primarily 5 packages, that contain classes for each functionality in it's totality.
- Package com.guide.merchant contains class MerchantsGuide that is main class containing the main method. This class is the point of entry into the application. This class takes the input file name as argument, parse the file and read all the valid lines into an ArrayList.
- Package com.guide.merchant.commandparser contains CommandParser class, which takes the ArrayList of read lines and returns an ArrayList of Commands that need to be executed, after decoding string of each line.
- Package com.guide.merchant.databank contains DataBank class, that stores the mapping of Roman numerals to their meant word and mapping of credit value of each item being sold.
- Package com.guide.merchant.roman contains RomanNumber class, that converts a given Roman number to it's corresponding Arabic value.
- Package com.guide.merchant.command contains 5 classes for each command type that can be generated from reading the input data which are implemented from ICommand interface. These classes are:
  - AssignmentCommand: This class executes command statement like "pish is I", i.e. pish = I
  - CreditAssignCommand: This class executes command statement like "pish Iron is 10 Credits", i.e. Iron = 10
  - HowMuchCommand: This class executes command statement like "how much is pish ?"
  - HowManyCommand: This class executes command statement like "how many Credits is pish Iron ?"
  - UnknownCommand: This class executes command that is not a valid command statement with an error message
- Unit test cases have been implemented for the classes.

####Environment Used

- For the development of this problem statement I have used the Java 8 environment for development.
- For writing unit test cases for the developed code I have used the JUnit 4 environment.

####Assumptions

Following are some of the assumptions I have taken into consideration while developing the code for the given problem statement:
- The first argument to the program is the input file. Input file is a must.
- All the command statement should be on a single line of the input file.
- Empty lines or line with just white spaces in input file will be ignored.
- All input words for assignment commands should be in lower case only, i.e. pish is valid, but not Pish or PISH
- Input words for assignment commands should contain on letters between a-z, i.e. pish is valid, but not pish9
- The only valid unit is "Credits" and can be understood as either "credits" or "Credits" but not as CREDITS
- Roman numerals must be provided only in capital for assignment commands, i.e. I, V, C, M, X, L, D.
- "is" is separator for assignment command statements, i.e. pish is I
- For credit assignment command statements input words should be lower case, while item's first character should be in upper case while, rest of characters should be in lower case, i.e. valid items are "Iron", "Gold", etc and invalid items are "iron", "gold", etc.
- For "how much" and "how many" command statements, they should end with a "?"
- All assumptions for assignment command and credit assignment command are also valid for "how much" and "how many" commands as well.
