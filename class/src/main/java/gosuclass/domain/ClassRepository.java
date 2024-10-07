package gosuclass.domain;

import gosuclass.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "classes", path = "classes")
public interface ClassRepository
    extends PagingAndSortingRepository<Class, Long> {}
