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
    collectionResourceRel = "gosuClasses",
    path = "gosuClasses"
)
public interface GosuClassRepository
    extends PagingAndSortingRepository<GosuClass, Long> {
    @Query(
        value = "select gosuClass " +
        "from GosuClass gosuClass " +
        "where(:id is null or gosuClass.id = :id) and (:className is null or gosuClass.className like %:className%) and (:gosuName is null or gosuClass.gosuName like %:gosuName%) and (:description is null or gosuClass.description like %:description%) and (:personCount is null or gosuClass.personCount = :personCount)"
    )
    GosuClass findByClassPage(
        Long id,
        String className,
        String gosuName,
        String description,
        Integer personCount
    );
}
