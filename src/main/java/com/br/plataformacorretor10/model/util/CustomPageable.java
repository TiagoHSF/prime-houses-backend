package com.br.plataformacorretor10.model.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Objects;

public class CustomPageable {

    public static Pageable generatePage(final Integer page, final Integer size, final String order){
        Sort sort;
        if (Objects.nonNull(order)) {
            sort = Sort.by(Sort.Order.asc(order));
        } else {
            sort = Sort.by(Sort.Order.asc("id"));
        }
        return PageRequest.of(page, size, sort);
    }
}
