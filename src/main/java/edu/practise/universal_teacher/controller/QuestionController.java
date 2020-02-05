package edu.practise.universal_teacher.controller;

import edu.practise.universal_teacher.model.Question;
import edu.practise.universal_teacher.services.question.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class QuestionController {
    private final QuestionServiceImpl questionService;

    @Autowired
    public QuestionController(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Question> questions = questionService.findAllQuestions();
        model.put("questions", questions);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String questionText,
                      @RequestParam String tag,
                      Map<String, Object> model) {
        Question question = new Question(questionText, tag);
        questionService.saveQuestion(question);

        Iterable<Question> questions = questionService.findAllQuestions();
        model.put("questions", questions);

        return "main";
    }

    @PostMapping("/main/filter")
    public String filter(@RequestParam String filterInp,
                         Map<String, Object> model) {
        List<Question> questions;
        if(filterInp!=null && !filterInp.isEmpty()){
            questions = questionService.getQuestionByTag(filterInp);
        }else {
            questions = questionService.findAllQuestions();
        }

        model.put("questions", questions);

        return "main";
    }
}
