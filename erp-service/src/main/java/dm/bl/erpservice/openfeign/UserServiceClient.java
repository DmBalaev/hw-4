package dm.bl.erpservice.openfeign;

import dm.bl.erpservice.dto.ClientInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(name = "USER-SERVICE", url = "http://localhost:8091")
public interface UserServiceClient {


    @GetMapping("/auth/erp/clients/byId")
    ResponseEntity<ClientInfoDto> getClientInfoByClientId(@RequestParam UUID clientId);

}
