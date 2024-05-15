package com.ltsoftwaresupport.analyticalflow.endpoint;

import com.ltsoftwaresupport.analyticalflow.exception.DefaultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class DefaultEndpoint<T, ID, R extends JpaRepository<T, ID>> {

    protected R repository;

    @Autowired
    public DefaultEndpoint(R repository) {
        this.repository = repository;
    }

    public enum Mode {
        SAVE,
        UPDATE,
        LIST,
        DELETE,
        LOAD;
    }

    protected void validate(T entity, Mode mode) throws DefaultException {}

    public T save(T object) throws DefaultException {
        validate(object, Mode.SAVE);
        return repository.save(object);
    }

    public T update(T object) throws DefaultException {
        validate(object, Mode.UPDATE);
        return repository.save(object);
    }


    public void delete(T object) throws DefaultException {
        validate(object, Mode.DELETE);
        repository.delete(object);
    }

    public List<T> list() throws DefaultException {
        validate(null, Mode.LIST);
        return repository.findAll();
    }

    public T load(ID id) throws DefaultException {
        return repository.findById(id).orElseThrow(() -> new DefaultException("Não existe"));
    }
}