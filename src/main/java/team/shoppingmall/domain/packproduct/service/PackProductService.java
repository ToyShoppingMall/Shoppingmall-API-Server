package team.shoppingmall.domain.packproduct.service;

import team.shoppingmall.domain.packproduct.dto.service.FilterSearchServiceDTO;
import team.shoppingmall.domain.packproduct.dto.service.FoundPackProductServiceDTO;

import java.util.List;

public interface PackProductService {

    FoundPackProductServiceDTO searchOne(Integer id);
    List<FoundPackProductServiceDTO> searchAllByPaginationAndFilter(FilterSearchServiceDTO filterSearchServiceDTO);
}
