package dm.bl.userservice.controller;

import dm.bl.userservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("auth/erp/clients")
@RequiredArgsConstructor
public class ErpClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<?> allClients(){
        return ResponseEntity.ok(clientService.getAll());
    }

    @GetMapping("/byId")
    public ResponseEntity<?> getClientInfoByClientId(@RequestParam UUID clientId){
        return ResponseEntity.ok(clientService.getClientInfo(clientId));
    }

}
