﻿# java-quiz-application-for-pc
 This Java application implements a simple quiz application using the Swing framework for the graphical user interface (GUI). Below is a detailed description of its functionality and structure:

### Overview
The application presents a series of multiple-choice questions to the user. It includes a timer for each question, and it tracks the user's score. At the end of the quiz, the user's score is displayed.

### Key Components

1. **Question Class**:
    - **Attributes**:
        - `questionText`: Stores the text of the question.
        - `options`: An array of strings representing the possible answers.
        - `correctAnswer`: A string representing the correct answer.
    - **Constructor**: Initializes the attributes with provided values.

2. **QuizGUI Class**:
    - **Attributes**:
        - `JFrame frame`: The main window of the application.
        - `JPanel panel`: The panel containing all GUI components.
        - `JLabel questionLabel`: Displays the current question.
        - `JRadioButton[] optionButtons`: An array of radio buttons for the answer options.
        - `ButtonGroup optionsGroup`: Groups the radio buttons so only one can be selected at a time.
        - `JButton submitButton`: Button to submit the selected answer.
        - `JLabel timerLabel`: Displays the time left for the current question.
        - `ArrayList<Question> questions`: Stores the list of questions.
        - `int currentQuestionIndex`: Tracks the index of the current question.
        - `int score`: Tracks the user's score.
        - `Timer timer`: Manages the countdown timer.
        - `TimerTask task`: Defines the task to be executed by the timer.
        - `int timeLeft`: Tracks the time left for the current question.
    - **Constructor**: Sets up the GUI components and adds event listeners.
    - **Methods**:
        - `addQuestion(Question question)`: Adds a question to the quiz.
        - `start()`: Starts the quiz by displaying the first question and starting the timer.
        - `showQuestion()`: Displays the current question and resets the timer.
        - `checkAnswer(String selectedOption)`: Checks if the selected answer is correct and updates the score.
        - `moveToNextQuestion()`: Moves to the next question or shows the results if all questions have been answered.
        - `showResults()`: Displays the final score and ends the quiz.
        - `startTimer()`: Starts the countdown timer for the current question.
        - `resetTimer()`: Resets the timer for the next question.

3. **QuizApplication Class**:
    - **main(String[] args)**: The entry point of the application. It creates an instance of `QuizGUI`, adds questions to the quiz, and starts the quiz.

### Functionality
1. **Initialization**: The GUI components are set up in the `QuizGUI` constructor. This includes creating and arranging labels, radio buttons, and buttons on the panel.
2. **Adding Questions**: Questions are added to the `questions` list using the `addQuestion` method.
3. **Starting the Quiz**: The `start` method initializes the quiz by displaying the first question and starting the timer.
4. **Displaying Questions**: The `showQuestion` method updates the `questionLabel` and `optionButtons` to show the current question and its options. It also resets the timer.
5. **Answer Submission**: When the user clicks the submit button, the selected answer is checked. If correct, the score is incremented. The quiz then moves to the next question.
6. **Timer**: The `startTimer` method sets up a countdown timer for each question. If the time runs out, the quiz automatically moves to the next question.
7. **Results**: After all questions are answered, the `showResults` method displays the user's score and ends the quiz.

### Example Questions
The quiz contains sample questions on various topics, such as general knowledge, Java programming, and science.

This application provides a simple but effective way to create a timed quiz with a graphical interface. It can be extended to include more questions, different question types, or enhanced GUI features.
