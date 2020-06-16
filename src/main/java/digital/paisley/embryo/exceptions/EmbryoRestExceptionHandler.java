package digital.paisley.embryo.exceptions;

import digital.paisley.commons.error.DefaultRestExceptionHandler;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE+1)
class EmbryoRestExceptionHandler extends DefaultRestExceptionHandler {
}
