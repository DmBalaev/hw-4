package dm.bl.userservice.service.impl;

import dm.bl.userservice.dto.ClientDtoCreator;
import dm.bl.userservice.dto.ClientInfoDto;
import dm.bl.userservice.exception.EntityNotFoundException;
import dm.bl.userservice.mapper.ClientMapper;
import dm.bl.userservice.repository.ClientRepository;
import dm.bl.userservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientInfoDto> getAll() {
        return clientRepository.findAll().stream()
                .map(clientMapper::convertToInfoDto)
                .toList();
    }

    @Override
    public ClientInfoDto getClientInfo(UUID clientId) {
        var clientInfo = clientRepository.findById(clientId)
                .orElseThrow(()-> new EntityNotFoundException("entity not found"));
        return clientMapper.convertToInfoDto(clientInfo);
    }

    @Override
    public void createNewClient(ClientDtoCreator createClientDto) {

    }
}
