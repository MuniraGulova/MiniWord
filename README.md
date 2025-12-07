## Text Editor Application — Java Swing Implementation
---
1. Overview
This project represents a text editor developed using Java Swing. It includes functionality for file management, text editing operations, font formatting tools, and a status bar that displays statistical information about the text.
The text area remains disabled until a new file is created or an existing file is opened.

2. Functional Capabilities
2.1. File Operations
The following commands are implemented:
Create a new file
Open an existing file
Save the current file
Close the file
Exit the application
2.2. Edit Operations
The editor supports standard editing actions:
- Text selection
- Cut
- Copy
- Paste
2.3. Text Formatting Tools
The application provides tools for modifying font parameters:
- Font family selection
- Font size adjustment
- Font color selection
- Font styles: bold, italic, underline
2.4. Status Bar Statistics
The status bar displays the following text statistics:
- Number of paragraphs
- Number of words
- Number of sentences
- Total number of characters
- Number of characters excluding spaces
- Number of digits
- Number of Latin letters
- Number of Cyrillic letters
- Number of punctuation marks
- Number of special characters

3. Technologies Used
- Java SE
- Java Swing
- AWT
- Java IO
- Java Regular Expressions

4. Launch Instructions
To compile and run the application using JDK:
```
javac Main.java
java Main
``
The project can also be opened in any IDE supporting Java.

5. Notes
The implementation corresponds to the requirements of an academic assignment and focuses on correctness and clarity of fundamental text editing and processing functions.
