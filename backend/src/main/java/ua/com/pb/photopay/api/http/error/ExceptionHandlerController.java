package ua.com.pb.photopay.api.http.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.viewmodels.errors.Error;

import static ua.com.pb.photopay.infrastructure.exceptions.EntityNotFoundException.*;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
@ControllerAdvice
public class ExceptionHandlerController {

    /**
     * Logger
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Handles entity is not found error
     * @param ex exception that occurred
     * @return error's description
     */
    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    public Error entityWasNotFound(EntityNotFoundException ex){
        logger.error(CODE + " " + ex.getMessage() + ". Entity " + ex.entity);
        return new Error(CODE, ex.entity);
    }

    /**
     * Handles entity already exists error
     * @param ex exception that occurred
     * @return error's description
     */
    @ResponseBody
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public Error entityExists(EntityAlreadyExistsException ex){
        logger.error(EntityAlreadyExistsException.CODE + " " + ex.getMessage() + ". Entity " + ex.entity);
        return new Error(EntityAlreadyExistsException.CODE, ex.entity);
    }

    /**
     * Handles entity is not found error
     * @param ex exception that occurred
     * @return error's description
     */
    @ResponseBody
    @ExceptionHandler(InvalidDataException.class)
    public Error invalidData(InvalidDataException ex){
        logger.error(InvalidDataException.CODE + " " + ex.getMessage() + ". Entity " + ex.entity);
        return new Error(InvalidDataException.CODE, ex.entity);
    }

    /**
     * Handles errors while creation or updating is made
     * @param ex exception that occurred
     * @return error's description
     */
    @ResponseBody
    @ExceptionHandler(CanNotCreateEntityException.class)
    public Error canNotCreateEntity(CanNotCreateEntityException ex){
        logger.error(CanNotCreateEntityException.CODE + " " + ex.getMessage() + ". Entity " + ex.entity);
        return new Error(CanNotCreateEntityException.CODE, ex.entity);
    }

    /**
     * Handles usege of the forbidden delivery channels
     * @param ex exception that occurred
     * @return error's description
     */
    @ResponseBody
    @ExceptionHandler(UsesForbiddenChannelException.class)
    public Error forbiddenChannel(UsesForbiddenChannelException ex){
        logger.error(UsesForbiddenChannelException.CODE + " " + ex.getMessage() + ". Entity " + ex.entity);
        return new Error(UsesForbiddenChannelException.CODE, ex.entity);
    }

    /**
     * Handles when indicative for branch not found
     * @param ex exception that occurred
     * @return error's description
     */
    @ResponseBody
    @ExceptionHandler(IndicativeNotFoundException.class)
    public Error indicativeNotFound(IndicativeNotFoundException ex){
        logger.error(IndicativeNotFoundException.CODE + " " + ex.getMessage());
        return new Error(IndicativeNotFoundException.CODE, null);
    }



}
