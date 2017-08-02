package ua.com.pb.photopay.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.pb.photopay.dao.repositories.RoleRepository;
import ua.com.pb.photopay.dao.repositories.UserRepository;
import ua.com.pb.photopay.infrastructure.constants.Constants;
import ua.com.pb.photopay.infrastructure.domain.UserService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.mappers.UserMapper;
import ua.com.pb.photopay.infrastructure.models.Application;
import ua.com.pb.photopay.infrastructure.models.Authority;
import ua.com.pb.photopay.infrastructure.models.User;
import ua.com.pb.photopay.infrastructure.viewmodels.user.UserAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.user.UserForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.user.UserForView;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by dn110592kvo on 06.07.2017.
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public boolean isAdmin(String ldap) {
        User user = userRepository.findByUsernameIgnoreCase(ldap);
        if (user != null) {
            return user.getAuthorities().stream().anyMatch(r -> r.getName().equals(Constants.Roles.ROLE_ADMIN));
        }
        return false;
    }

    @Override
    public boolean isAccounter(String ldap) {
        User user = userRepository.findByUsernameIgnoreCase(ldap);
        if (user != null) {
            return user.getAuthorities().stream().anyMatch(r -> r.getName().equals(Constants.Roles.ROLE_ACCOUNTANT));
        }
        return false;
    }

    @Override
    public boolean hasAccess(String ldap) {
        return false;
    }

    @Override
    public UserForView find(Integer integer) throws EntityNotFoundException {
        return null;
    }

    @Override
    public boolean canRead(String ldap, Application application) {
        return false;
    }


    @Override
    public List<UserAsListItem> findAll() {
        return null;
    }


    public List<UserForView> findAlls() {
        return userRepository.findAll().stream().map(u -> UserMapper.mapView(u)).collect(Collectors.toList());
    }

    @Override
    public boolean canWrite(String ldap) {
        return false;
    }

    @Override
    public Integer save(UserForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        if (newEntity != null) {

        }
        return null;
    }

    @Override
    public boolean canWrite(String ldap, Application application) {
        return false;
    }

    @Override
    public User getCurrent() {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Long create(String ldap) {
        User user = userRepository.findByUsernameIgnoreCase(ldap);
        if (user == null) {
            user = new User();
            makeGuest(user);
        }
        return (long) user.getId();
    }

    @Override
    public User create(Map<String, String> userParareters) {
        return null;
    }

    @Override
    public void makeModerator(User user) {
        if (user != null) {
            Authority authority = roleRepository.findByNameIgnoreCase(Constants.Roles.ROLE_MODERATOR);
            if (authority != null) {
                addRoleToUser(authority, user);
            }
        }
    }

    @Override
    public void makeGuest(User user) {
        if (user != null) {
            Authority authority = roleRepository.findByNameIgnoreCase(Constants.Roles.ROLE_GUEST);
            if (authority != null) {
                addRoleToUser(authority, user);
            }
        }
    }

    @Override
    public void makeAccounter(User user) {
        if (user != null) {
            Authority authority = roleRepository.findByNameIgnoreCase(Constants.Roles.ROLE_ACCOUNTANT);
            if (authority != null) {
                addRoleToUser(authority, user);
            }
        }
    }

    @Override
    public void makeAdmin(User user) {
        if (user != null) {
            Authority authority = roleRepository.findByNameIgnoreCase(Constants.Roles.ROLE_ADMIN);
            if (authority != null) {
                addRoleToUser(authority, user);
            }
        }
    }

    @Override
    public void makeManager(User user) {
        if (user != null) {
            Authority authority = roleRepository.findByNameIgnoreCase(Constants.Roles.ROLE_MANAGER);
            if (authority != null) {
                addRoleToUser(authority, user);
            }
        }
    }

    @Override
    public void unmakeModerator(User user) {
        if (user != null) {
            Authority authority = roleRepository.findByNameIgnoreCase(Constants.Roles.ROLE_MODERATOR);
            if (authority != null) {
                removeUserRole(authority, user);
            }
        }
    }

    @Override
    public void unmakeGuest(User user) {
        if (user != null) {
            Authority authority = roleRepository.findByNameIgnoreCase(Constants.Roles.ROLE_GUEST);
            if (authority != null) {
                removeUserRole(authority, user);
            }
        }
    }

    @Override
    public void unmakeAccounter(User user) {
        if (user != null) {
            Authority authority = roleRepository.findByNameIgnoreCase(Constants.Roles.ROLE_ACCOUNTANT);
            if (authority != null) {
                removeUserRole(authority, user);
            }
        }
    }

    @Override
    public void unmakeAdmin(User user) {
        if (user != null) {
            Authority authority = roleRepository.findByNameIgnoreCase(Constants.Roles.ROLE_ADMIN);
            if (authority != null) {
                removeUserRole(authority, user);
            }
        }
    }

    @Override
    public void unmakeManager(User user) {
        if (user != null) {
            Authority authority = roleRepository.findByNameIgnoreCase(Constants.Roles.ROLE_MANAGER);
            if (authority != null) {
                removeUserRole(authority, user);
            }
        }
    }

    @Override
    public void saveTransactions(User user) {
        userRepository.save(user);
    }

    @Override
    public User find(String ldap) {
        if (ldap != null) {
            User user = userRepository.findByUsernameIgnoreCase(ldap);
            if (user != null) return user;
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        if (email != null) {
            User user = userRepository.findByEmailIgnoreCase(email);
            if (user != null) return user;
        }
        return null;
    }


    /**
     * Add authority to user
     *
     * @param authority
     * @param user
     */
    private void addRoleToUser(Authority authority, User user) {
        List<Authority> userAuthorities = user.getAuthorities();
        if (userAuthorities == null) userAuthorities =  new ArrayList<>();
        if (userAuthorities.add(authority)) {
            user.setAuthorities(userAuthorities);
            saveTransactions(user);
        }
    }

    /**
     * Remove authority of user
     *
     * @param authority
     * @param user
     */
    private void removeUserRole(Authority authority, User user) {
        List<Authority> userAuthorities = user.getAuthorities();
        if (userAuthorities != null) {
            if (userAuthorities.remove(authority)) {
                user.setAuthorities(userAuthorities);
                saveTransactions(user);
            }
        }
    }
}
