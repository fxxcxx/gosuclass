package gosuclass.domain;

import gosuclass.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "evaluations",
    path = "evaluations"
)
public interface EvaluationRepository
    extends PagingAndSortingRepository<Evaluation, Long> {}
