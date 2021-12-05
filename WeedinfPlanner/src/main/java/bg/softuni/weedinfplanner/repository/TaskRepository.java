package bg.softuni.weedinfplanner.repository;

import bg.softuni.weedinfplanner.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findAllByInitial(boolean initial);

    List<Task> findAllByWeddingUserEmail(String email);

    Long countAllByCompletedAndWeddingUserEmail(boolean completed, String email);

    Long countAllByWeddingUserEmail(String email);
}
