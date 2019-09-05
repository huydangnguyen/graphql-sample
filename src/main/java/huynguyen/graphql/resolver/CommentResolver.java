package huynguyen.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import huynguyen.graphql.model.Answer;
import huynguyen.graphql.model.Comment;
import huynguyen.graphql.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentResolver implements GraphQLResolver<Comment> {
    @Autowired
    private AnswerRepository answerRepository;

    public Answer getAnswer(Comment comment) {
        Long answerId = comment.getAnswerId();
        return answerRepository.findById(answerId).orElseGet(null);
    }
}
