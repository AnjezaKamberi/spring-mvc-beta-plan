package com.betaplan.anjeza.store.mapper;

public interface BaseMapper<E, D> {
    E toEntity(D dto);

    D toDTO(E entity);
}
