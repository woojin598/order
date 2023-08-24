package kr.co.tj.orderservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Payload { // 실제 데이터 payload.
//	private String orderId;
	private String username;
//	private String productId;
	private String artist;
	private String title;
	private String itemDescribe;
	private String address;
	private Long qty;
	private Long unitPrice;
	private Long totalPrice;
}
