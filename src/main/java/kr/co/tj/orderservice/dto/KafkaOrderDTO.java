package kr.co.tj.orderservice.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class KafkaOrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Schema schema;
	private Payload payload;
}
