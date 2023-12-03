package team.shoppingmall.convertor;

import team.shoppingmall.domain.packproduct.PackProduct;
import team.shoppingmall.domain.packproduct.dto.controller.FilterSearchRequestDTO;
import team.shoppingmall.domain.packproduct.dto.controller.FoundPackProductResponseDTO;
import team.shoppingmall.domain.packproduct.dto.repository.FilterSearchRepositoryDTO;
import team.shoppingmall.domain.packproduct.dto.service.FilterSearchServiceDTO;
import team.shoppingmall.domain.packproduct.dto.service.FoundPackProductServiceDTO;

public class PackProductConvertor {

    public static FoundPackProductServiceDTO convert(PackProduct packProduct) {
        return new FoundPackProductServiceDTO(
                packProduct.getId(),
                packProduct.getName(),
                packProduct.getPrice()
        );
    }

    public static FoundPackProductResponseDTO convert(FoundPackProductServiceDTO dto) {
        return new FoundPackProductResponseDTO(
                dto.getId(),
                dto.getName(),
                dto.getPrice()
        );
    }

    public static FilterSearchRepositoryDTO convert(FilterSearchServiceDTO dto) {
        return new FilterSearchRepositoryDTO(
                dto.getName(),
                dto.getPrice()
        );
    }

    public static FilterSearchServiceDTO convert(FilterSearchRequestDTO dto) {
        return new FilterSearchServiceDTO(
                dto.getName(),
                dto.getPrice()
        );
    }
}
