package team.shoppingmall.domain.packproduct.repository;

import team.shoppingmall.domain.packproduct.PackProduct;
import team.shoppingmall.domain.packproduct.dto.repository.FilterSearchRepositoryDTO;

import java.util.List;
import java.util.Optional;

public interface PackProductRepository {

    Optional<PackProduct> findOneById(Integer id);
    List<PackProduct> findAllByPaginationAndFilter(FilterSearchRepositoryDTO filterSeekRepositoryDTO);
}
