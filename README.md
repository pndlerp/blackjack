# Blackjack Game (JavaFX)

A simple desktop Blackjack game built with Java and JavaFX. This is my first project on GitHub.

The game features classic gameplay against a computer dealer, with no betting system or balance tracking.

## Features
* 1v1 gameplay: Player vs Dealer.
* Automatic score calculation (Ace counts as 1 or 11 based on classic rules).
* Dealer AI logic: the dealer hits on under 17 and stands on 17 or higher.
* Simple graphical user interface (UI).

## Demo Showcase

[gameplay.webm](https://github.com/user-attachments/assets/6645138e-1e64-4926-9b7f-de43010efd23)


## Tech Stack
* **Java** (version 14)
* **JavaFX**
* Build tool: **Maven**

## How to Run (Linux)

Follow these steps to run the game on Linux.

### Prerequisites
Make sure you have JDK 14 (or higher) installed. You can check your version by running `java -version`.

### Installation & Launch
Copy and run the following commands in your terminal:

git clone https://github.com/Paerma/blackjack.git
cd blackjack
chmod +x mvnw
./mvnw clean javafx:run

(Alternatively, you can just open this project in IntelliJ IDEA or Eclipse and run the Controller.java class directly)
