package com.example.demo.service;

import com.example.demo.dto.BasketDto;

/**
 * @author YMS01
 * @date 30.11.2022 14:22
 */
public interface BasketService {

    BasketDto findById(Long id);

    void update(Long id, BasketDto basketDto);
}
