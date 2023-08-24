package kr.co.tj.orderservice.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kr.co.tj.orderservice.dto.OrderResponse;



@FeignClient(name = "catalog-service")
public interface CatalogFeign {
	@PutMapping("/catalog-service/catalogs/productid")
	public String updateStockByProductId(@RequestBody OrderResponse orderResponse);
}
