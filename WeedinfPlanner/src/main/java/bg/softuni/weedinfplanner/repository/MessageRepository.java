package bg.softuni.weedinfplanner.repository;

import bg.softuni.weedinfplanner.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {

    List<Message> findAllBySupplierEmailAndReplyFromSupplierOrderByIdDesc(String email, Boolean isReplyFromSupplier);
    List<Message> findAllByUserEmailAndReplyFromSupplierOrderByIdDesc(String email, Boolean isReplyFromSupplier);
}
