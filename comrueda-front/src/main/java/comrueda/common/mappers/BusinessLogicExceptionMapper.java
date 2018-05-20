package comrueda.common.mappers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import comrueda.common.exceptions.BusinessLogicException;

@Provider
public class BusinessLogicExceptionMapper implements ExceptionMapper<BusinessLogicException> {

    public Response toResponse(BusinessLogicException exception) {
        return Response.status(Response.Status.PRECONDITION_FAILED)
                .entity(getInitCause(exception).getLocalizedMessage())
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build(); 
    }

    private Throwable getInitCause(Throwable e) {
        if (e.getCause() != null) {
            return getInitCause(e.getCause());
        } else {
            return e;
        }
    }

}