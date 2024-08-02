package br.com.jeffersonandrade.desafio_btgpactual.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.jeffersonandrade.desafio_btgpactual.entity.OrderEntity;
@Repository
public interface OrderRepository extends MongoRepository<OrderEntity, Long>{

    Page<OrderEntity> findAllByCustomerId(Long customerId, PageRequest page);

}
