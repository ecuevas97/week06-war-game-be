# week06-war-game-be

# 🎴 War Card Game — Week 6 Java Project

This project is a simple **automated version of the classic card game WAR**, built in **Java** as part of my Week 6 assignment for the Promineo Tech Back-End Developer course.

The game automatically simulates two players drawing cards from a shuffled deck and compares their values each round until the deck is empty — printing round results, score updates, and the final winner in the console.

---

## 🧠 Project Overview

**Concepts Used:**
- Object-Oriented Programming (OOP)
- Classes, Objects, Fields, and Methods
- Lists and Loops
- Encapsulation and Instantiation

**Classes Included:**
- `Card` → defines a playing card with a name and value  
- `Deck` → creates a full deck of 52 cards, shuffles, and draws cards  
- `Player` → stores a hand, score, and contains methods like `draw()`, `flip()`, and `incrementScore()`  
- `App` → runs the game logic, simulating the rounds and determining the winner  

---

## ⚙️ How It Works

1. A new `Deck` is created and shuffled.  
2. Two `Player` objects are instantiated and dealt 26 cards each.  
3. Each round, both players flip a card.  
4. The higher value card wins the round and earns 1 point.  
5. The game continues for 26 rounds and declares the final winner.

---

## ▶️ How to Run

1. Open the project in **Eclipse** (or your IDE of choice).  
2. Open `App.java`.  
3. Run the file (`Right-click → Run As → Java Application`).  
4. Watch the results in the **Console** window!

---

## 📽️ Demo Video

🎥 [YouTube Walkthrough: https://www.youtube.com/watch?v=HpRzcWVTF4A]

---

## 📚 Author

👩‍💻 **Elena Cuevas**  
[GitHub](https://github.com/ecuevas97) • [LinkedIn](https://www.linkedin.com/in/elena-cuevas-28b65aa4/)


