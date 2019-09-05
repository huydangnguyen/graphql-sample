package huynguyen.graphql.repository;

import huynguyen.graphql.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
