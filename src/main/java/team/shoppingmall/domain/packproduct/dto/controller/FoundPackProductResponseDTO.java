package team.shoppingmall.domain.packproduct.dto.controller;

import team.shoppingmall.domain.packproduct.dto.AbstractFoundPackProductDTO;

public class FoundPackProductResponseDTO extends AbstractFoundPackProductDTO {
    public FoundPackProductResponseDTO(Integer id, String name, Integer price) {
        super(id, name, price);
    }
}
