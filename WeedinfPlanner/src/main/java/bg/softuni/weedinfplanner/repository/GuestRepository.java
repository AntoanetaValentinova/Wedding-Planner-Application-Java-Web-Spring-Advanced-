package bg.softuni.weedinfplanner.repository;

import bg.softuni.weedinfplanner.model.entity.Guest;
import bg.softuni.weedinfplanner.model.entity.enums.AttendEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {

    List<Guest> findAllByWeddingToAttend_User_Email(String email);

    Long countAllByAttendAndWeddingToAttendUserEmail(AttendEnum attend, String email);
}
