//package kr.co.tj.orderservice.dto;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class OrderDTO implements Serializable{
//	private static final long serialVersionUID = 1L;
//	
//	private Long id;
//	
//	private String username;
//
//	private String productId;
//
//	private String orderId;
//	
//	private Long qty;
//
//	private Long unitPrice;
//
//	private Long totalPrice;
//	
//	private Date createAt;
//	private Date updateAt;
//	
//	public static OrderDTO toOrderDTO(OrderRequest orderRequest) {
//		return OrderDTO.builder()
//				.username(orderRequest.getUsername())
//				.productId(orderRequest.getProductId())
//				.qty(orderRequest.getQty())
//				.unitPrice(orderRequest.getUnitPrice())
//				.build();
//	}
//
//	public OrderResponse toOrderResponse() {
//		return OrderResponse.builder()
//				.username(username)
//				.createAt(createAt)
//				.orderId(orderId)
//				.productId(productId)
//				.qty(qty)
//				.totalPrice(totalPrice)
//				.unitPrice(unitPrice)
//				.updateAt(updateAt)
//				.build();
//	}
//
//	public OrderEntity toOrderEntity() {
//		return OrderEntity.builder()
//				.username(username)
//				.productId(productId)
//				.orderId(orderId)
//				.qty(qty)
//				.unitPrice(unitPrice)
//				.totalPrice(totalPrice)
//				.createAt(createAt)
//				.updateAt(updateAt)
//				.build();
//	}
//
//	public static OrderDTO toOrderDTO(OrderEntity orderEntity) {
//		// TODO Auto-generated method stub
//		return OrderDTO.builder()
//				.username(orderEntity.getUsername())
//				.productId(orderEntity.getProductId())
//				.orderId(orderEntity.getOrderId())
//				.qty(orderEntity.getQty())
//				.unitPrice(orderEntity.getUnitPrice())
//				.totalPrice(orderEntity.getTotalPrice())
//				.createAt(orderEntity.getCreateAt())
//				.updateAt(orderEntity.getUpdateAt())
//				.build();
//	}
//
//	
//	
//}
 package kr.co.tj.orderservice.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	  	
	private String username;
		
	private String artist;
	
	private String title;
	
	private String itemDescribe;

	private String address;
//	 
	private String productId;
//
	private String orderId;
//	
	private Long qty;

	private Long price;

	private Long totalPrice;
	
	 
	
	private byte[] bytes;
	
	private Date createDate;
	
	private Date updateDate;
	

	
	public static OrderDTO toOrderDTO(OrderRequest orderRequest) {
		
		return OrderDTO.builder()
				.orderId(orderRequest.getOrderId())
				.username(orderRequest.getUsername())
				.artist(orderRequest.getArtist())
				.title(orderRequest.getTitle())
				.itemDescribe(orderRequest.getItemDescribe())
				.address(orderRequest.getAddress())
				.username(orderRequest.getUsername())
				.qty(orderRequest.getQty())
				.price(orderRequest.getPrice())
				.build();
	}
	
	public static OrderDTO toOrderDTO(OrderEntity orderEntity) {
		
		return OrderDTO.builder()
				.orderId(orderEntity.getOrderId())
				.productId(orderEntity.getProductId())
				.artist(orderEntity.getArtist())
				.title(orderEntity.getTitle())
				.itemDescribe(orderEntity.getItemDescribe())
				.address(orderEntity.getAddress())
				.username(orderEntity.getUsername())//_0605 수정
				.qty(orderEntity.getQty())
				.bytes(orderEntity.getBytes())
				.price(orderEntity.getPrice())
				.totalPrice(orderEntity.getTotalPrice())

				.build();
	}
	
	public OrderResponse toOrderResponse() {
		
		return OrderResponse.builder()
				.orderId(orderId)
				.productId(productId)
				.username(username)//_0605 수정
				.artist(artist)
				.title(title)
				.itemDescribe(itemDescribe)
				.address(address)
				.qty(qty)
				.price(price)
				.totalPrice(totalPrice)
				.createDate(createDate)
				.updateDate(updateDate)
				.build();
	}
	
	public OrderEntity toOrderEntity() {
		
		return OrderEntity.builder()
				.username(username)
				.orderId(orderId)
				.productId(productId)
				.artist(artist)
				.title(title)
				.itemDescribe(itemDescribe)
				.qty(qty)
				.price(price)
				.totalPrice(totalPrice)
				.bytes(bytes)
				.address(address)
				.build();
	}
	
	public void setId(UUID randomUUID) {
		this.id = id;
	}

	public static OrderDTO toOrderDTO(OrderDTO dto) {
		return OrderDTO.builder()
				 
				.artist(dto.getArtist())
				.title(dto.getTitle())
				.itemDescribe(dto.getItemDescribe())
				.address(dto.getAddress())
				.qty(dto.getQty())
				.bytes(dto.getBytes())
				.username(dto.getUsername())//_0605 수정
				.price(dto.getPrice())


				.build();
	}
}

