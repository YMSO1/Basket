package com.example.demo.mapper;

import com.example.demo.dto.BasketDto;
import com.example.demo.model.Basket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author YMS01
 * @date 30.11.2022 14:14
 */
@Mapper
public interface BasketMapper {
    BasketMapper INSTANCE = Mappers.getMapper(BasketMapper.class);

    Basket basketDtoToBasket(BasketDto basketDto);

    BasketDto basketToBasketDto(Basket basket);
}
