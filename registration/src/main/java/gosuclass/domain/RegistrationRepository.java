package gosuclass.domain;
import java.util.List;  // java.util 패키지에서 List를 import
import gosuclass.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "registrations",
    path = "registrations"
)
public interface RegistrationRepository extends PagingAndSortingRepository<Registration, Long> {

    // classId로 Registration 엔티티들을 조회하는 메서드
    List<Registration> findByClassId(Long classId);
}