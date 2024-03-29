package dm.bl.userservice.service;

import dm.bl.userservice.dto.ClientDtoCreator;
import dm.bl.userservice.dto.ClientInfoDto;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    List<ClientInfoDto> getAll();
    ClientInfoDto getClientInfo(UUID clientId);

    void createNewClient(ClientDtoCreator createClientDto);
}
