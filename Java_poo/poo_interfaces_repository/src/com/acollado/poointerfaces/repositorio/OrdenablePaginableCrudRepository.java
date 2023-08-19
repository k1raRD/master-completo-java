package com.acollado.poointerfaces.repositorio;

public interface OrdenablePaginableCrudRepository<T> extends OrdenableRepositorio<T>
        ,PaginableRepositorio<T>, CrudRepositorio<T>, ContableRepositorio {
}
