package kz.yeldos.delivery.service;

import kz.yeldos.delivery.dto.UserDTO;
import kz.yeldos.delivery.mapper.UserMapper;
import kz.yeldos.delivery.model.User;
import kz.yeldos.delivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user!=null){
            return user;
        }else{
            throw new UsernameNotFoundException("User Not Found!");
        }
    }
    public List<UserDTO> getUsers(){
        return userMapper.toDtoList(userRepository.findAll());
    }
    public UserDTO getUser(Long id){
        return userMapper.toDto(userRepository.findById(id).orElse(null));
    }

    public UserDTO addUser(UserDTO userDTO){
        User checkUser = userRepository.findByEmail(userDTO.getEmail());
        if(checkUser==null){
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userDTO.setPreOrder(false);
            return userMapper.toDto(userRepository.save(userMapper.toModel(userDTO)));
        }
        return null;
    }
    public UserDTO updateUser(UserDTO userDTO){
        return userMapper.toDto(userRepository.save(userMapper.toModel(userDTO)));
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updatePassword(String oldPassword, String newPassword){
        User currentUser = getCurrentSessionUser();
        if(passwordEncoder.matches(oldPassword,currentUser.getPassword())){
            currentUser.setPassword(passwordEncoder.encode(newPassword));
            return userRepository.save(currentUser);
        }
        return null;
    }
    public User getCurrentSessionUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            User user = (User) authentication.getPrincipal();
            if(user!=null){
                return user;
            }
        }
        return null;
    }
    public void updateFullName(String newFullName){
        User currentUser = getCurrentSessionUser();
        currentUser.setFullName(newFullName);
        userRepository.save(currentUser);
    }
}
