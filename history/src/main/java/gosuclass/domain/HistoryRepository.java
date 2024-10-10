package gosuclass.domain;

import gosuclass.domain.*;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "histories", path = "histories")
public interface HistoryRepository
        extends PagingAndSortingRepository<History, Long> {
             // classId와 personId로 History를 찾는 메서드 정의
        Optional<History> findByClassIdAndPersonId(Long classId, Long personId);
        }