package shop.dziupla.spring.login.mappers;

import org.mapstruct.Mapper;
import shop.dziupla.spring.login.models.DAO.CompanyInfo;
import shop.dziupla.spring.login.payload.response.CompanyInfoDTO;

@Mapper(componentModel = "spring")
public interface CompanyInfoMapper {
    CompanyInfoDTO carToCarDto(CompanyInfo entity);
    CompanyInfo companyInfoDTOToCompanyInfo(CompanyInfoDTO dto);
}
