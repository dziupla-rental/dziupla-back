package shop.dziupla.spring.login.mappers;

import org.mapstruct.*;
import shop.dziupla.spring.login.models.DAO.Client;
import shop.dziupla.spring.login.payload.response.ClientDTO;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "lastName", source = "user.lastname")
    @Mapping(target = "role", expression = "java(user.getRole().getName().name())")
    ClientDTO clientToClientDTO(Client client);
    Client clientDTOToClient(ClientDTO clientDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "user.username", source = "username")
    @Mapping(target = "user.email", source = "email")
    @Mapping(target = "user.name", source = "name")
    @Mapping(target = "user.lastname", source = "lastName")
    void updateClientFromDto(ClientDTO dto, @MappingTarget Client entity);
}
