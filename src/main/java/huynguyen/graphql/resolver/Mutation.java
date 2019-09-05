package huynguyen.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import huynguyen.graphql.model.Answer;
import huynguyen.graphql.model.Comment;
import huynguyen.graphql.model.Question;
import huynguyen.graphql.repository.AnswerRepository;
import huynguyen.graphql.repository.CommentRepository;
import huynguyen.graphql.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private CommentRepository commentRepository;

    public Question newQuestion(String title, String content) {
        Question question = new Question();
        question.setTitle(title);
        question.setContent(content);
        return questionRepository.save(question);
    }

    public Answer newAnswer(String content, Long questionId) {
        Question question = questionRepository.findById(questionId).orElseGet(null);
        if (question == null) {
            return null;
        }
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setQuestion(question);
        answer.setQuestionId(questionId);
        return answerRepository.save(answer);
    }

    public Comment newComment(String content, Long answerId) {
        Answer answer = answerRepository.findById(answerId).orElseGet(null);
        if (answer == null) {
            return null;
        }
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setAnswer(answer);
        comment.setAnswerId(answerId);
        return commentRepository.save(comment);
    }
}
