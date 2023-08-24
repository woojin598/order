package kr.co.tj.orderservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.tj.orderservice.dto.OrderDTO;
import kr.co.tj.orderservice.dto.OrderEntity;
import kr.co.tj.orderservice.dto.OrderResponse;
import kr.co.tj.orderservice.fegin.CatalogFeign;
import kr.co.tj.orderservice.jpa.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CatalogFeign catalogFeign;
//	@Autowired
//	private TokenProvider tokenProvider;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	
	public OrderDTO createOrder(OrderDTO orderDTO) {
		
		
		orderDTO = getDate(orderDTO);
		
//		orderDTO.setOrderId(UUID.randomUUID().toString());
		
		orderDTO.setTotalPrice(orderDTO.getPrice() * orderDTO.getQty());
		
		OrderEntity orderEntity = orderDTO.toOrderEntity();
		
		orderEntity = orderRepository.save(orderEntity);
		
		orderDTO = OrderDTO.toOrderDTO(orderEntity);
		
		return orderDTO;
	}
//		OrderResponse orderResponse = orderDTO.toOrderResponse();
//		
//		String result = catalogFegin.updateStockByProductId(orderResponse);
//		
//		if(result.startsWith("0")) {
//			orderRepository.delete(orderEntity);
//			return null;
//		}
		
	private OrderDTO getDate(OrderDTO orderDTO) {
		Date now = new Date();
		
		if(orderDTO.getCreateDate() == null) {
			orderDTO.setCreateDate(now);
		}
		
		orderDTO.setUpdateDate(now);
		
		return orderDTO;
	}
	


	//주문목록가져오기(username)_0605 수정
	public List<OrderDTO> getOrdersByUsername(String username) {
		List<OrderEntity> dbList = orderRepository.findByUsername(username);
		List<OrderDTO> list = new ArrayList<>();
		
		for(OrderEntity x : dbList) {
			OrderDTO orderDTO = OrderDTO.toOrderDTO(x);
			list.add(orderDTO);
		}
		
		return list;
	}
	

	public List<OrderDTO> getOrdersByItem(String orderid) {
		List<OrderEntity> dbList = orderRepository.findByUsername(orderid);
		List<OrderDTO> list = new ArrayList<>();
		
		for(OrderEntity x : dbList) {
			OrderDTO orderDTO = OrderDTO.toOrderDTO(x);
			list.add(orderDTO);
		}
		
		return list;
	}
	
	
//	public OrderEntity getByCredentials(String orderId) {
//		return orderRepository.findByOrderId(orderId);
//		}

	//삭제
	@Transactional
	public void delete(Long id) {
		 orderRepository.deleteById(id);		
	}
	
	//수정
//	@Transactional
//	public String updateItemByTitle(OrderEntity orderEntity) {
//		
//		try {
//			OrderEntity existingItem = orderRepository.findByProductId(orderEntity.getProductId());
//			
//			if(existingItem == null) {
//				return "failed";
//			}
//			
//			existingItem.setArtist(orderEntity.getArtist());
//			existingItem.setItemDescribe(orderEntity.getItemDescribe());
//			existingItem.setAddress(orderEntity.getAddress());
//			existingItem.setQty(orderEntity.getQty());
//			existingItem.setPrice(orderEntity.getPrice());
//			existingItem.setUpdateDate(new Date());
//			
//			orderRepository.save(existingItem);
//			
//			return "ok";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "failed";
//		}
//	}

	
}

	
	// 주문 정보 수정
//	@Transactional
//	public OrderDTO editOrder(OrderDTO orderDTO) {
//		OrderEntity orderEntity = orderRepository.findByOrderId(orderDTO.getOrderId());
//		
//		if (orderEntity == null) {
//			throw new RuntimeException("주문 정보가 잘못됐습니다...");
//		}
//		
////		if (!passwordEncoder.matches(orderDTO.getPassword, null)) {
////			
////		}
//		
//		orderEntity.setUnitPrice(orderDTO.getUnitPrice() - (orderDTO.getUnitPrice() - (orderDTO.getQty() * orderDTO.getUnitPrice())));
//		orderEntity.setTotalPrice(orderDTO.getUnitPrice() * orderDTO.getQty());
//		
//		return orderDTO;
//	}
	
	//주문 생성
//	public OrderDTO createOrder(OrderDTO orderDTO) {
//
//		orderDTO = getDate(orderDTO);
//		
//		OrderEntity orderEntity = orderDTO.toOrderEntity();
//		
//		
////		orderDTO.setCreateDate(nowDate);
////		orderDTO.setUpdateDate(nowDate);
//		
//		
//		orderEntity = orderRepository.save(orderEntity);
//				
////		String result = orderFeign.updateStockByProductId(orderResponse);
////		
////		if(result.startsWith("0")) {
////			orderRepository.delete(orderEntity);
////			
////			return null;
////		}
//		 
//		return orderDTO.toOrderDTO(orderEntity);
//	}
	
//	public OrderDTO editOrder(OrderDTO orderDTO) {
//		
//		orderDTO = getDate(orderDTO);
//		
//		orderDTO.getTitle();
//		orderDTO.getProductId();
//		
//		orderDTO.setPrice(orderDTO.getPrice());
//		
//		orderDTO.setTotalPrice(orderDTO.getPrice() * orderDTO.getQty());
//		
//		OrderEntity orderEntity = orderDTO.toOrderEntity();
//		orderEntity = orderRepository.save(orderEntity);
//		
//		OrderResponse orderResponse = orderDTO.toOrderResponse();
//		
//		String result = catalogFeign.updateStockByProductId(orderResponse);
//		
//		if(result.startsWith("0")) {
//			orderRepository.delete(orderEntity);
//			
//			return null;
//		}
//		
//		return orderDTO;
//	}

	
