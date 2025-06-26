# 🔔 Alarm Button Puzzle App

An Android alarm clock app where you must tap the correct sequence of symbols to dismiss the alarm — no more lazy mornings! 💤💥

## 💡 Features
- Set exact alarm time using Android AlarmManager
- Fun pattern-based mini-game to dismiss alarms
- Alarm rings even when the phone is idle (with permission setup) ##still working on this feature
- Designed in Kotlin + Android Studio
- Alarm sound using MediaPlayer

## 🚧 Known Issues

> These are current limitations we're aware of and actively working on.

### ❗ Alarm does not trigger when app is in background or screen is off
- **Cause:** Android restricts background execution & UI launches in idle state (esp. Android 12+)
- **Plan:** Will implement a **foreground service + wake lock** so the app wakes reliably and pops the screen

## 🚀 How to Run
- Open in Android Studio
- Run on a real device (make sure permissions are granted)
- Set the alarm, wait, and try solving the puzzle when it rings 🎮

## 🛠 Tech Stack
- Kotlin
- Android SDK
- MediaPlayer
- AlarmManager
- Android Permissions (Battery optimization & exact alarms)

---

> Built with ❤️ by Rohit and ChatGPT

