package com.actfinal.ut7.src.main.java.com.actfinal.ut7.service;

import java.util.List;
import java.util.Optional;



public interface CrudService<T, ID> {

    /**
     * Retrieves all entities.
     *
     * @return a list of all entities
     */
    List<T> getAll();

    /**
     * Retrieves an entity by its ID.
     *
     * @param id the ID of the entity
     * @return an Optional containing the entity if found, or empty if not found
     */
    Optional<T> getById(ID id);

    /**
     * Saves a new entity or updates an existing one.
     *
     * @param entity the entity to save or update
     * @return the saved or updated entity
     */
    T save(T entity);

    /**
     * Updates an existing entity.
     *
     * @param entity the entity to update
     * @return the updated entity
     */
    T update(ID id, T entity);

    /**
     * Deletes an entity by its ID.
     *
     * @param id the ID of the entity to delete
     */
    void deleteById(ID id);
    
}
