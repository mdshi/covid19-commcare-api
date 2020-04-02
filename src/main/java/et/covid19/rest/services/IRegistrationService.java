package et.covid19.rest.services;

import et.covid19.rest.dal.model.User;

public interface IRegistrationService {
    void registerUser(User user);
}
