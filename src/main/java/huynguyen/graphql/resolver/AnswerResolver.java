package huynguyen.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import huynguyen.graphql.model.Answer;
import huynguyen.graphql.model.Question;
import huynguyen.graphql.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnswerResolver implements GraphQLResolver<Answer> {
    @Autowired
    private QuestionRepository questionRepository;

    public Question getQuestion(Answer answer) {
        Long questionId = answer.getQuestionId();
        return questionRepository.findById(questionId).orElseGet(null);
    }
}
