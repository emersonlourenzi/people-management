package br.com.peoplemanagement.impl.repository;

import br.com.peoplemanagement.impl.repository.entity.PeopleEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PeopleRepository extends ReactiveMongoRepository<PeopleEntity, String> {
}
