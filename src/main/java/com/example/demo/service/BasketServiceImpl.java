package com.example.demo.service;

import com.example.demo.dto.BasketDto;
import com.example.demo.mapper.BasketMapper;
import com.example.demo.model.Basket;
import com.example.demo.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YMS01
 * @date 30.11.2022 14:29
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class BasketServiceImpl implements BasketService {
    private final BasketRepository repository;

    @Override
    public BasketDto findById(Long id) {
        log.info("Basket with id = {} was found", id);
        return BasketMapper.INSTANCE.basketToBasketDto(repository.findById(id).get());
    }

    @Override
    @Transactional
    public void update(Long id, BasketDto basketDto) {
        Basket fromDto = BasketMapper.INSTANCE.basketDtoToBasket(basketDto);
        Basket newBasket = repository.findById(id).get();

        newBasket.setDocumentList(fromDto.getDocumentList());
        repository.save(newBasket);
        log.info("Basket was updated: {}", newBasket);
    }
}
