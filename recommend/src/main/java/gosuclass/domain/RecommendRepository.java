package gosuclass.domain;

import gosuclass.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "recommends",
    path = "recommends"
)
public interface RecommendRepository
    extends PagingAndSortingRepository<Recommend, Long> {
    @Query(
        value = "select recommend " +
        "from Recommend recommend " +
        "where(:id is null or recommend.id = :id) and (:personId is null or recommend.personId = :personId) and (:classId is null or recommend.classId = :classId) and (:className is null or recommend.className like %:className%)"
    )
    Recommend findByRecommendPage(
        Long id,
        Long personId,
        Long classId,
        String className
    );
}
