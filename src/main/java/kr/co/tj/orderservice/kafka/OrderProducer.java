package kr.co.tj.orderservice.kafka;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.tj.orderservice.dto.Field;
import kr.co.tj.orderservice.dto.KafkaOrderDTO;
import kr.co.tj.orderservice.dto.OrderDTO;
import kr.co.tj.orderservice.dto.Payload;
import kr.co.tj.orderservice.dto.Schema;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j //log관련
public class OrderProducer {
	
	//여기에 @autowired하는 것보다 (자동주입 안되는 경우에 찾기 어려움)
	//아래처럼 기본생성자에 멤버변수로 넣어주는 것이 더 완벽한 코드.
	private KafkaTemplate<String, String> KafkaTemplate;
	
	List<Field> fields = Arrays.asList( //orderRequest클래스의 변수 참고
			                  //notnull제약조건 -> false
			new Field("string", false, "username"),
//			new Field("string", false, "productId"),
			new Field("int32", false, "qty"),
			new Field("int32", false, "unitPrice"),
//			new Field("string", false, "orderId"),
			new Field("int32", false, "totalPrice")

			);
	
	Schema schema = Schema.builder()
			.type("struct")
			.fields(fields)
			.optional(false)
			.name("orders")
			.build();
			
			
	
	@Autowired
	public OrderProducer(KafkaTemplate<String, String> KafkaTemplate) {
		this.KafkaTemplate = KafkaTemplate;
	}
	
	//컨트롤러or오더서비스에서 호출하는 메서드.
	public OrderDTO send(String topic, OrderDTO orderDTO) {//orderDTO 참고
		
		Payload payload = Payload.builder()
				.username(orderDTO.getUsername())
//				.productId(orderDTO.getProductId())
				.qty(orderDTO.getQty())
				.unitPrice(orderDTO.getPrice())
				.totalPrice(orderDTO.getTotalPrice())
//				.orderId(orderDTO.getOrderId())
				.build();
		
		
		
		KafkaOrderDTO kafkaOrderDTO = KafkaOrderDTO.builder()
				.schema(schema)
				.payload(payload)
				.build();
		
		
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = null;
		
		try {
			jsonData = mapper.writeValueAsString(kafkaOrderDTO);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		KafkaTemplate.send(topic, jsonData);
		//서버 돌릴때는 sysout 안씀.
		log.info("주문과 관련된 데이터를 카프카로 전송합니다." + kafkaOrderDTO);
		
		return orderDTO;
	}

}