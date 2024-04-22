# LeagueOfLanguage
LeagueOfLanguage is a stack-based esoteric programming language inspired by different champions on the Summoner's Rift

## Getting Started
To run LeagueOfLanguage programs, you'll need the LeagueOfLanguageInterpreter. This interpreter reads .rift files containing LeagueOfLanguage instructions and executes them.

## Instructions
- `NUNU`: Push 0 onto the stack.
- `LEBLANC`: Duplicate the top value of the stack.
- `YUUMI`: Add 1 to the top value of the stack.
- `ZAC`: Pops A and then B from the stack and pushes B - A to the stack.
- `THRESH`: Takes one character of input and pushes its ASCII code to the stack.
- `POPPY`: Pop the top value of the stack and print it as an ASCII character.
- `HEIMER`: Pop the top value of the stack and print it as an integer.
- `JHIN` `n`: Pop the top of the stack. If it is zero, jump to the `nth` line.
- `TAHMKENCH`: Pop the top of the stack and push it to the bottom.
- `JANNA`: Remove the bottom value of the stack and push it to the top.
- `PYKE`: Terminate program execution.

