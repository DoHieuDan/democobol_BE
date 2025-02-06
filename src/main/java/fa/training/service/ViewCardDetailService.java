package fa.training.service;

import fa.training.repository.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ViewCardDetailService {
    static final String CCDA_MSG_THANK_YOU = "Thank you for using CardDemo application...      ";
    static final String CCDA_MSG_INVALID_KEY = "Invalid key pressed. Please see below...         ";

    UserRepository userRepository;


}
