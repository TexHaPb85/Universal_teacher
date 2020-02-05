package edu.practise.universal_teacher.services.question;

import edu.practise.universal_teacher.model.Question;
import edu.practise.universal_teacher.reposetories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestionByTag(String tag){
        return questionRepository.findByTag(tag);
    }

    public List<Question> findAllQuestions() {
        Iterable<Question> questionIterable = questionRepository.findAll();
        List<Question> questions = new ArrayList<>();
        questionIterable.forEach(questions::add);
        return questions;
    }

    public Iterable<Question> findAllQuestionsIter(){
        return questionRepository.findAll();
    }

    @Override
    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }


}
