package gosuclass.infra;

import gosuclass.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "personalPages",
    path = "personalPages"
)
public interface PersonalPageRepository
    extends PagingAndSortingRepository<PersonalPage, Long> {}
