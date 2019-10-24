package edu.practise.universal_teacher.services.question;

import edu.practise.universal_teacher.entities.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionByTag(String tag);

    List<Question> findAllQuestions();

    void saveQuestion(Question question);
}
