package br.com.qualirede.procedimentos.services.Mappers;

public interface MapperEntity<T, TDto> {
    T DtoToEntiy(TDto entity);
    TDto EntityToDto(T entity);
}
