package gosuclass.domain;

import gosuclass.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "registrations",
    path = "registrations"
)
public interface RegistrationRepository
    extends PagingAndSortingRepository<Registration, Long> {}
