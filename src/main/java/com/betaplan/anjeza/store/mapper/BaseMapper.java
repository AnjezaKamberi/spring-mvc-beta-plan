package com.betaplan.anjeza.store.mapper;

import java.util.List;

public interface BaseMapper<E, D> {
    E toEntity(D dto);

    D toDTO(E entity);

    List<E> toEntityList(List<D> dtos);

    List<D> toDTOList(List<E> entities);
}
