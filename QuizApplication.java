import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    String questionText;
    String[] options;
    String correctAnswer;

    public Question(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

class QuizGUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup optionsGroup;
    private JButton submitButton;
    private JLabel timerLabel;
    private ArrayList<Question> questions;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;
    private TimerTask task;
    private int timeLeft;

    public QuizGUI() {
        frame = new JFrame("Quiz Application");
        panel = new JPanel();
        questionLabel = new JLabel("");
        optionButtons = new JRadioButton[4];
        optionsGroup = new ButtonGroup();
        submitButton = new JButton("Submit");
        timerLabel = new JLabel("Time left: 30");

        questions = new ArrayList<>();
        currentQuestionIndex = 0;
        score = 0;
        timeLeft = 30;

        panel.setLayout(new GridLayout(7, 1));

        panel.add(questionLabel);
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i] = new JRadioButton();
            optionsGroup.add(optionButtons[i]);
            panel.add(optionButtons[i]);
        }
        panel.add(timerLabel);
        panel.add(submitButton);

        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (optionsGroup.getSelection() != null) {
                    String selectedOption = optionsGroup.getSelection().getActionCommand();
                    checkAnswer(selectedOption);
                    moveToNextQuestion();
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select an answer.");
                }
            }
        });
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start() {
        showQuestion();
        startTimer();
    }

    private void showQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionLabel.setText(currentQuestion.questionText);
            for (int i = 0; i < currentQuestion.options.length; i++) {
                optionButtons[i].setText(currentQuestion.options[i]);
                optionButtons[i].setActionCommand(currentQuestion.options[i]);
            }
            optionsGroup.clearSelection();
            resetTimer();
        } else {
            showResults();
        }
    }

    private void checkAnswer(String selectedOption) {
        Question currentQuestion = questions.get(currentQuestionIndex);
        if (selectedOption.equals(currentQuestion.correctAnswer)) {
            score++;
        }
    }

    private void moveToNextQuestion() {
        currentQuestionIndex++;
        showQuestion();
    }

    private void showResults() {
        timer.cancel();
        JOptionPane.showMessageDialog(frame, "Quiz Finished! Your score: " + score + "/" + questions.size());
        frame.dispose();
    }

    private void startTimer() {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                timeLeft--;
                timerLabel.setText("Time left: " + timeLeft);
                if (timeLeft <= 0) {
                    timer.cancel();
                    JOptionPane.showMessageDialog(frame, "Time's up! Moving to the next question.");
                    moveToNextQuestion();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 3000, 3000);
    }

    private void resetTimer() {
        timeLeft = 30;
        if (timer != null) {
            timer.cancel();
        }
        startTimer();
    }
}

public class QuizApplication {
    public static void main(String[] args) {
        QuizGUI quiz = new QuizGUI();

        quiz.addQuestion(new Question(
                "1.What is the capital of France?",
                new String[]{"a. London", "b. Berlin", "c. Paris", "d. Madrid"},
                "Paris"
        ));

        quiz.addQuestion(new Question(
                "2.Which planet is known as the Red Planet?",
                new String[]{"a. Earth", "b. Mars", "c. Jupiter", "d. Venus"},
                "Mars"
        ));

        quiz.addQuestion(new Question(
                "3.What is the largest ocean on Earth?",
                new String[]{"a. Atlantic Ocean", "b. Indian Ocean", "c. Arctic Ocean", "d. Pacific Ocean"},
                "Pacific Ocean"
        ));

        quiz.addQuestion(new Question(
                "4.Which of the following is not a Java features?",
                new String[]{"a. Dynamic" ,"b. Architecture Neutral","c. Use of pointers","d. Object-oriented"},
                "Use of pointers"
        ));

        quiz.addQuestion(new Question(
                "5.Which of the following is a reserved keyword in Java?",
                new String[]{"a. object" ,"b. strictfp","c. main","d. system"},
                "strictfp"
        ));

        quiz.start();
    }
}


