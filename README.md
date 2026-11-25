# Number Guessing Game

A terminal-based number guessing game written in Java. Pick a difficulty level, guess the secret number, and try to keep your score as high as possible.

## Features

- 3 difficulty levels (Easy, Medium, Hard)
- "Too high" / "Too low" hints after every wrong guess
- Scoring system: start with 100 points, lose 10 per wrong guess
- Input validation, so wrong input types don't crash the game
- Typewriter-style text output
- Play again option after each round

## Levels

| Level | Range  | Attempts |
|-------|--------|----------|
| Easy   | 1-10  | 5        |
| Medium | 1-50  | 20       |
| Hard   | 1-100 | 40       |

## How to Run

Requires Java (JDK 8 or higher).

```bash
javac NumberGuessingGame.java
java NumberGuessingGame
```

## How to Play

1. Choose a level (1, 2, or 3).
2. Enter your guess.
3. Use the "Too high" / "Too low" hints to narrow it down.
4. Guess the number before your attempts run out.
5. Enter `1` to play again, or any other number to exit.
