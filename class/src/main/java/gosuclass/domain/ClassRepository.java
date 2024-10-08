package gosuclass.domain;

import gosuclass.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "classes", path = "classes")
public interface ClassRepository
    extends PagingAndSortingRepository<Class, Long> {
    @Query(
        value = "select class " +
        "from Class class " +
        "where(:id is null or class.id = :id) and (:className is null or class.className like %:className%) and (:classId is null or class.classId = :classId) and (:gosuName is null or class.gosuName like %:gosuName%) and (:description is null or class.description like %:description%) and (:personCount is null or class.personCount like %:personCount%)"
    )
    Class findByClassPage(
        Long id,
        String className,
        Long classId,
        String gosuName,
        String description,
        String personCount
    );
}
