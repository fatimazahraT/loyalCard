package com.example.app.Service;

import com.example.app.Models.User;
import com.example.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
    }

    @Override
    public User updateUser(Long userId, User updatedUser) {
        User existingUser = getUserById(userId);
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setUserType(updatedUser.getUserType());
        existingUser.setUserBankCode(updatedUser.getUserBankCode());
        existingUser.setUserBranchCode(updatedUser.getUserBranchCode());
        existingUser.setNumberOfTries(updatedUser.getNumberOfTries());
        existingUser.setNumberOfTriesAllowed(updatedUser.getNumberOfTriesAllowed());
        existingUser.setIpAddressMang(updatedUser.getIpAddressMang());
        existingUser.setIpAddress(updatedUser.getIpAddress());
        existingUser.setConnected(updatedUser.getConnected());
        existingUser.setFirstConnection(updatedUser.getFirstConnection());
        existingUser.setNbreSessionAllowed(updatedUser.getNbreSessionAllowed());
        existingUser.setNbreSessionConnected(updatedUser.getNbreSessionConnected());
        existingUser.setLengthPassword(updatedUser.getLengthPassword());
        existingUser.setComplexityFlag(updatedUser.getComplexityFlag());
        existingUser.setExpirationPassword(updatedUser.getExpirationPassword());
        existingUser.setDateStartPass(updatedUser.getDateStartPass());
        existingUser.setDateEndPass(updatedUser.getDateEndPass());
        existingUser.setBlockAccess(updatedUser.getBlockAccess());
        existingUser.setLanguageCode(updatedUser.getLanguageCode());
        existingUser.setLast4Pwd(updatedUser.getLast4Pwd());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setMobileNumber(updatedUser.getMobileNumber());
        existingUser.setForgotPwdRequest(updatedUser.getForgotPwdRequest());
        existingUser.setSecretKey(updatedUser.getSecretKey());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found with username: " + username));
    }

}
