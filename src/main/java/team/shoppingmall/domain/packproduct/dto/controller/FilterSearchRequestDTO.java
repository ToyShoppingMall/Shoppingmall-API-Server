package team.shoppingmall.domain.packproduct.dto.controller;

import team.shoppingmall.domain.packproduct.dto.AbstractFilterSearchDTO;

public class FilterSearchRequestDTO extends AbstractFilterSearchDTO {

    public FilterSearchRequestDTO(String name, Integer price) {
        super(name, price);
    }
}
