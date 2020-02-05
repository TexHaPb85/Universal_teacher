package edu.practise.universal_teacher.reposetories;

import edu.practise.universal_teacher.model.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question,Long> {
    List<Question> findByTag(String tag);
}
