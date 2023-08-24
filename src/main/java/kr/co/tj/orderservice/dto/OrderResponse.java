package kr.co.tj.orderservice.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String username;//_0605 수정
	private String artist;
	private String title;
	private String itemDescribe;
	private Long qty;
	private String address;
	private Long price;
	private Long totalPrice;
	private String orderId;
	private String productId;
	
	
	@JsonProperty("create_date")
	private Date createDate;
	
	@JsonProperty("update_date")
	private Date updateDate;
	
}