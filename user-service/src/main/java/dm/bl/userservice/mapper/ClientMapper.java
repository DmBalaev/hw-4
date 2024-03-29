package dm.bl.userservice.mapper;

import dm.bl.userservice.dto.ClientInfoDto;
import dm.bl.userservice.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientInfoDto convertToInfoDto(Client client){
        return new ClientInfoDto(
                client.getId(),
                client.getFirstName(),
                client.getMiddleName(),
                client.getLastName()
        );
    }
}
