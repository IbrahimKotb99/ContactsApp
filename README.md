# ContactsApp (Android With Kotlin Course Project)

This repository contains the ContactsApp project I completed as part of my Android development course using Kotlin. It serves as a practical demonstration of various Android components, APIs, and development concepts, including a complete contacts management system with data validation.

## About This Project

This application is a contacts management app designed to explore specific features of the Android framework. It showcases my ability to build a clean, functional application that integrates different Android functionalities into a single, cohesive user experience.

## How to Install and Test the App (APK)

For easy testing, a pre-built APK file is available. Follow these steps to install it on your Android device:

1. **Download the APK:**
   - Navigate to the [Releases](../../releases) section of this GitHub repository.
   - Download the latest `.apk` file (e.g., `app-release.apk`).

2. **Enable Installation from Unknown Sources:**
   - On your Android device, go to **Settings > Security** (or a similar path).
   - Find and enable the **Install unknown apps** permission for your browser or file manager.

3. **Install the APK:**
   - Open your device's **File Manager**, go to your **Downloads** folder, and tap on the downloaded `.apk` file.
   - Confirm the installation when prompted.

4. **Run the App:**
   - Once installed, find the app's icon in your app drawer and open it.

## Features Implemented

This project includes the following features:

- ✨ **Splash Screen:** A timed splash screen that provides a professional entry point into the app.
- 📇 **Contacts Management:**
  - **Add Contact:** Users can add new contacts with name, email, and phone number through a bottom sheet dialog.
  - **View Contacts:** Contacts are displayed in a grid layout using RecyclerView.
  - **Delete Contact:** Each contact has a delete button to remove it from the list.
  - **Empty State:** When no contacts exist, a Lottie animation and message are shown.
- ✅ **Input Validation:**
  - Name validation (letters only)
  - Email validation (proper email format)
  - Phone validation (7-15 digits)
  - Real-time error messages displayed in text fields
- 🎨 **Material Design UI:** Clean, modern interface following Material Design guidelines with custom themes and colors.

## Technologies and Concepts Learned

- **Core Components:** `Activity`, `RecyclerView`, `ViewBinding`, `Material Components`.
- **User Interface:** XML Layouts (`CoordinatorLayout`, `ConstraintLayout`), Material Design components (`FloatingActionButton`, `BottomSheetDialog`, `TextInputLayout`).
- **Data Management:** 
  - Kotlin data classes
  - MutableList for in-memory storage
  - RecyclerView Adapter pattern
- **Event Handling:** `OnClickListener`, lambda expressions, and event-driven programming.
- **Input Validation:** 
  - Custom validation utility object
  - Android Patterns for email validation
  - Regex for phone number validation
- **Third-Party Libraries:**
  - Lottie for animations
  - Material Components for modern UI
  - ViewBinding for type-safe view access
- **Version Control:** All project history is managed with Git and hosted on GitHub.

## How To Build From Source

These instructions are for developers who want to build the project themselves.

1. **Clone the repository:**
   ```bash
   git clone https://github.com/YOUR_USERNAME/ContactsApp.git
   cd ContactsApp
   ```

2. **Open in Android Studio:**
   - Open the project in Android Studio (latest version recommended).

3. **Sync Dependencies:**
   - Let Gradle sync the project and download all required dependencies.

4. **Run the app:**
   - Run the app on an emulator or a physical device.

## Project Structure

```
ContactsApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/contactsapp/
│   │   │   │   ├── Contact.kt              # Data class for contact
│   │   │   │   ├── ContactsActivity.kt     # Main contacts screen
│   │   │   │   ├── ContactsAdapter.kt      # RecyclerView adapter
│   │   │   │   ├── SplashActivity.kt       # Splash screen
│   │   │   │   └── ValidationUtils.kt      # Input validation logic
│   │   │   ├── res/
│   │   │   │   ├── layout/                 # XML layout files
│   │   │   │   ├── drawable/               # Icons and graphics
│   │   │   │   ├── values/                 # Colors, strings, themes
│   │   │   │   └── raw/                    # Lottie animation files
│   │   │   └── AndroidManifest.xml
│   │   └── build.gradle.kts
│   └── build.gradle.kts
└── README.md
```

## Screenshots

*(Add screenshots of your app here)*

## Dependencies

```kotlin
// Core Android
implementation("androidx.core:core-ktx:1.13.1")
implementation("androidx.appcompat:appcompat:1.7.0")
implementation("com.google.android.material:material:1.12.0")
implementation("androidx.activity:activity:1.9.3")
implementation("androidx.constraintlayout:constraintlayout:2.2.0")
implementation("androidx.coordinatorlayout:coordinatorlayout:1.2.0")

// Lottie animations
implementation("com.airbnb.android:lottie:6.6.2")
```

## What I Learned

Through building this project, I gained hands-on experience with:

- Implementing RecyclerView with custom adapters
- Using ViewBinding for cleaner code
- Creating reusable validation utilities
- Working with Material Design components
- Managing app state and UI updates
- Handling user input and validation
- Using Kotlin features like data classes, lambdas, and object declarations

## Future Improvements

Potential enhancements for this project:

- Persist contacts using Room Database or SharedPreferences
- Add contact editing functionality
- Implement search/filter contacts
- Add contact photos from camera or gallery
- Share contact information
- Import/export contacts

## License

This project is for educational purposes.

## Contact

If you have any questions or suggestions, feel free to reach out!

---

**Note:** This is a learning project created as part of an Android development course.
