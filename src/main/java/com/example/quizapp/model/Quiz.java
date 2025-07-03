package com.example.quizapp.model;

// package com.example.quizapp.model;

// import java.util.ArrayList;

// public class Quiz {
//     // Attributes
//     private int id;
//     private String questionText;
//     private ArrayList<String> options;
//     private String correctAnswer;

//     public Quiz() {
//         System.out.println("Default constructor");
//     }
//     // Constructor
//     public Quiz(int id, String questionText, ArrayList<String> options, String correctAnswer) {
//         this.id = id;
//         this.questionText = questionText;
//         this.options = options;
//         this.correctAnswer = correctAnswer;
//     }

//     // Getters and Setters
//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public String getQuestionText() {
//         return questionText;
//     }

//     public void setQuestionText(String questionText) {
//         this.questionText = questionText;
//     }

//     public ArrayList<String> getOptions() {
//         return options;
//     }

//     public void setOptions(ArrayList<String> options) {
//         this.options = options;
//     }

//     public String getCorrectAnswer() {
//         return correctAnswer;
//     }

//     public void setCorrectAnswer(String correctAnswer) {
//         this.correctAnswer = correctAnswer;
//     }

//     @Override
//     public String toString() {
//         return ("ID: " + id +
//         		"\nQuestion: " + questionText +
//         		"\nOptions: " + options +
//         		"\nCorrect Answer: " + correctAnswer);
//     }

// }

import java.util.ArrayList;
import java.util.Arrays;

public class Quiz {
    private Integer id;
    private String question;
    private ArrayList<String> options; // Keep options as ArrayList<String>
    private String answer;

    // No-argument constructor (required for Thymeleaf binding)
    public Quiz() {
        this.options = new ArrayList<>();
    }

    // Constructor with parameters
    public Quiz(Integer id, String question, ArrayList<String> options, String answer) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    // Helper method to get options as a comma-separated string
    public String getOptionsAsString() {
        return String.join(",", options);
    }

    // Helper method to set options from a comma-separated string
    public void setOptionsFromString(String optionsString) {
        this.options = new ArrayList<>(Arrays.asList(optionsString.split(",")));
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return ("ID: " + id +
                "\nQuestion: " + question +
                "\nOptions: " + options +
                "\nCorrect Answer: " + answer);
    }
}
