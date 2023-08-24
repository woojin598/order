package kr.co.tj.orderservice.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DynamicInsert
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class OrderEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 안보이는 유저 id
	
	@Column(nullable = false)
	private String username; 
	
	
	@Column(nullable = false)
	private String artist;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String itemDescribe;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private Long qty;
	
	@Column(nullable = false)
	private Long price; // 통합 가격
	
	@Column(columnDefinition =  "MediumBLOB")// 자료형을 꼭 "MediumBLOB")로 설정. 안 하면 TinyBlob이 되어서 용량이 너무 적어 업로드가 안 됨.
	private byte[] bytes;
	
	@Column(nullable = false)
	private String productId;
	
	@Column(nullable = false, unique = true)
	private String orderId;
	
//	@Column(nullable = false)
//	private Long unitPrice;
//	
	@Column(nullable = false)
	private Long totalPrice;
	
 
	private Date createDate; // 데이터 생성 일시
	
 
	private Date updateDate; // 업데이트 일시
	 
	 


}
