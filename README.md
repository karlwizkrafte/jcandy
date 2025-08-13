<p align="center">
  <img src="img/JCandy_logo.png" alt="JCandy Logo" width="400"> <br>
  <img src="img/tagline.png" alt="type less, flavor your terminal_" width="350">
</p>

## Introduction
`JCandy` is a lightweight Java library that simplifies console output with easy printing, formatting, and colorful text styling, helping students and developers reduce boilerplate in terminal apps. 

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [API Usage](#api-usage)
  - [Importing](#importing)
  - [Method Usage](#method-usage)
  - [Flavorful Class](#flavorful-class)
- [Showcase](#showcase)
- [License](#license)

## Features
- Standardized CLI utilities for Java.
- Reduces repetitive code.
- Easy integration into existing projects.
- Adds colorful and styled text output for enhanced CLI aesthetics.

## Installation
To use `JCandy` in your project:

1. Download the latest release file from the [Releases](https://github.com/karlwizkrafte/JCandy/releases) page.
2. Extract the file.
3. Copy the `kvx` folder from the extracted `src/` directory into your own project's `src` directory.
4. Import and use the utilities in your Java code.

No additional setup or dependencies are required.

## API Usage

### Importing
To use the `Std` and `Flavorful` classes, import them into your Java file:

```java
import kvx.JCandy.Std;
import kvx.JCandy.Flavorful;
```

### Method Usage
The `Std` class provides the following utility methods:

#### Output Methods
- **`printf(String message)`**
  - Prints a formatted message.
  - Example:
    ```java
    Std.printf("Hello, World!");
    ```

- **`printf(String format, Object... args)`**
  - Prints a formatted message with arguments.
  - Example:
    ```java
    Std.printf("Hello, %s!", "World");
    ```

- **`print(String message)`**
  - Prints a message without a newline.
  - Example:
    ```java
    Std.print("Hello, World!");
    ```

- **`println(String message)`**
  - Prints a message with a newline.
  - Example:
    ```java
    Std.println("Hello, World!");
    ```

- **`println(String format, Object... args)`**
  - Prints a formatted message with a newline.
  - Example:
    ```java
    Std.println("Hello, %s!", "World");
    ```

- **`printError(String message, Object... args)`**
  - Prints an error message to `System.err`.
  - Example:
    ```java
    Std.printError("Error: %s", "Something went wrong!");
    ```

#### Utility Methods
- **`newl()`**
  - Prints a single newline.
  - Example:
    ```java
    Std.newl();
    ```

- **`newl(int range)`**
  - Prints multiple newlines.
  - Example:
    ```java
    Std.newl(3); // Prints 3 new lines
    ```

- **`delay(int millis)`**
  - Pauses execution for the specified number of milliseconds.
  - Example:
    ```java
    Std.delay(1000); // Pauses for 1 second
    ```

- **`clear()`**
  - Attempts to clear the terminal screen. Falls back to printing multiple newlines if unsupported.
  - Example:
    ```java
    Std.clear();
    ```

### Flavorful Class

> [!WARNING]  
> The `Flavorful` class is currently experimental and may undergo significant changes in future updates. Use it with caution in production environments.

The `Flavorful` class provides methods for adding colors, background colors, and styles to text output. This enhances the aesthetics of CLI applications.

#### Enums
- **`Color`**: Defines text colors (e.g., `red`, `green`, `blue`, etc.).
- **`BGColor`**: Defines background colors (e.g., `red`, `green`, `blue`, etc.).
- **`Style`**: Defines text styles (e.g., `bold`, `italic`, `underline`, etc.).

#### Methods
- **`flavor(Object... args)`**
  - Combines colors, background colors, and styles with text.
  - Example:
    ```java
    String styledText = Flavorful.flavor(Flavorful.Color.red, Flavorful.Style.bold, "Hello, World!");
    Std.println(styledText);
    ```

- **Convenience Methods**
  - **`bold(String text)`**: Makes text bold.
  - **`underline(String text)`**: Underlines text.
  - **`italic(String text)`**: Makes text italic.
  - **`dim(String text)`**: Dims text.
  - **`blink(String text)`**: Makes text blink.
  - **`reverse(String text)`**: Reverses text colors.
  - **`strikethrough(String text)`**: Strikes through text.

  Example:
  ```java
  String boldText = Flavorful.bold("Bold Text");
  Std.println(boldText);
  ```

## Showcase
Here is an example demonstrating how to use `JCandy` in your project:

```java
import kvx.JCandy.Std;
import kvx.JCandy.Flavorful;

public class Main {
    public static void main(String[] args) {
        // Example usage of JCandy Std utilities
        Std.newl();           // Print a new line
        Std.newl(2);          // Print 2 new lines
        Std.delay(500);       // Pause for 500 milliseconds
        Std.clear();          // Clear the terminal screen

        // Example usage of Flavorful utilities
        String styledText = Flavorful.flavor(Flavorful.Color.green, Flavorful.Style.bold, "Welcome to JCandy!");
        Std.println(styledText);

        Std.print("Enter your name: ");
        String name = "John Doe"; // Simulate user input
        Std.printf("Hello %s, welcome to JCandy!", name);
    }
}
```

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.
