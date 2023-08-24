package kr.co.tj.orderservice.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.tj.orderservice.dto.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
	
	List<OrderEntity> findByUsername(String username);
	
	Page<OrderEntity> findAll(Pageable pageable);
//
//	OrderEntity findByOrderId(String orderId);
//
//	OrderEntity findByProductId(String productId);


}
