package et.covid19.rest.services.impl;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.User;
import et.covid19.rest.dal.repositories.UserRepository;
import et.covid19.rest.services.IRegistrationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationServiceImpl implements IRegistrationService {

    final UserRepository userRepository;
    public RegistrationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    @EthLoggable
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)
    public void registerUser(User user) {
        userRepository.save(user);
    }
}
