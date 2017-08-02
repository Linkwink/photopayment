package ua.com.pb.photopay.infrastructure.domain;

/**
 * Created by dn110592kvo on 06.07.2017.
 */

import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.viewmodels.ViewModelAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.ViewModelForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.ViewModelForView;

import java.io.Serializable;
import java.util.List;

/**
 * Base service interface
 * @param <SAVE>  ViewModel that extends class ViewModelForSave and contains fields required for creation or updating of entity
 * @param <LIST>  ViewModel that extends class ViewModelAsListItem and contains required fields to display entity
 *                   as list item
 * @param <VIEW>  ViewModel that extends class ViewModelAsListItem and contains required fields to display entity
 *                   for details view
 * @param <ID>    class that entity uses as id
 */
public interface BaseService<
        SAVE extends ViewModelForSave,
        LIST extends ViewModelAsListItem,
        VIEW extends ViewModelForView,
        ID   extends Serializable
        > {
    /**
     * Finds specific instance in database with such id
     * @param id unique id
     * @return instance of class with such id
     */
    VIEW find(ID id) throws EntityNotFoundException;

    /**
     * Gets all instances of class
     * @return collection of instances
     */
    List<LIST> findAll();

    /**
     * Saves instance in database
     * @param newEntity required fields for creation
     * @return id of the new instance in database
     */
    ID save(SAVE newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException;

    /**
     * Deletes instance from database
     * @param id id of the instance
     */
    void delete(ID id);
}
