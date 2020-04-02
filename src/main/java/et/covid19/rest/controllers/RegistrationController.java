package et.covid19.rest.controllers;

import et.covid19.rest.config.AbstractController;
import et.covid19.rest.dal.model.User;
import et.covid19.rest.services.IRegistrationService;
import et.covid19.rest.swagger.api.RegisterApi;
import et.covid19.rest.swagger.model.JwtRequest;
import et.covid19.rest.swagger.model.ResponseBase;
import et.covid19.rest.util.exception.EthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegistrationController extends AbstractController implements RegisterApi {
    final IRegistrationService registrationService;
    public RegistrationController(IRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public ResponseEntity<ResponseBase> registerUser(@Valid JwtRequest userRequest) {
        Class<ResponseBase> responseClass = ResponseBase.class;
        ResponseBase response = null;
        HttpStatus status = HttpStatus.OK;

        try{
            User user = new User(userRequest.getFirstName(), userRequest.getLastName(),
                    userRequest.getEmail(), BCrypt.hashpw(userRequest.getPassword(), BCrypt.gensalt()));
            registrationService.registerUser(user);
            response = fillSuccessResponse(new ResponseBase());
        } catch (Exception ex) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response = fillFailResponseGeneric(responseClass);
        }

        return new ResponseEntity<>(response, status);
    }
}
