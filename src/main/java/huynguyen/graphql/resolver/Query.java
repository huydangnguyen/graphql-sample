package huynguyen.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import huynguyen.graphql.model.Answer;
import huynguyen.graphql.model.Comment;
import huynguyen.graphql.model.Question;
import huynguyen.graphql.repository.AnswerRepository;
import huynguyen.graphql.repository.CommentRepository;
import huynguyen.graphql.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private CommentRepository commentRepository;

    public List<Question> findAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Answer> findAnswers(Long questionId) {
        return answerRepository.findByQuestionId(questionId);
    }

    public List<Comment> findComments(Long answerId) {
        return commentRepository.findByAnswerId(answerId);
    }
}
