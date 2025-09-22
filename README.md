# 🔐 Guess Pin Code (Java Swing)

A simple **Java Swing desktop game** where the player tries to guess a randomly generated 4-digit PIN code.  
Each digit ranges from `0–9`, and no duplicate numbers are allowed.  

The program gives visual feedback with colors:
- 🟩 **Green** → Correct digit at the correct position.  
- 🟨 **Yellow** → Digit exists in the password but at the wrong position.  
- 🟥 **Red** → Digit is not part of the password.  

---

## 📌 Features
- Random **non-duplicate 4-digit PIN** generated each game.
- Increment/decrement digits using **arrow buttons**.
- Visual feedback with **colored digits**.
- **Restart** button to generate a new password.
- **Exit** button to quit the application.
- Simple and user-friendly **Swing GUI**.

---

## 🎮 How to Play
1. Use the **Up (▲)** and **Down (▼)** buttons to set digits.
2. Click **Check** to verify your guess.
3. If you guess correctly:
   - All digits turn **green**.
   - Message: `"You guessed the right password!"`
4. If incorrect:
   - Digits change color according to rules.
   - Message: `"Try again!"`
5. Click **Restart** to try with a new random password.

---

## 📂 Project Structure
```bash
src
   ├── controller
   │            └── GameController.java
   ├── logic
   │       └── GameLogic.java
   ├── view
   │      ├── CustomButton.java
   │      └── GamePanel.java
   └── Main.java
```

---
## 🖼️ Screenshot (Example)

<img width="496" height="369" alt="image" src="https://github.com/user-attachments/assets/1e658fc5-d866-491c-8f0e-25130ef725c2" />

---

## ⚙️ Installation & Run
1. Clone or download this repository.
2. Open it in your IDE (Eclipse, IntelliJ, VS Code with Java).
3. Compile and run `Main.java`.

```bash
javac Main.java
java Main
