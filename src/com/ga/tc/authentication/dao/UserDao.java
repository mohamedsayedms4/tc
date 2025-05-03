/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ga.tc.authentication.dao;

import com.ga.tc.authentication.dto.UserInfoDto;
import java.util.List;

/**
 *
 * @author Mohamed Sayed
 */
public interface UserDao {

    /**
     * Saves (inserts or updates) the user information and returns the old or
     * newly generated ID, or -1 if the save operation fails.
     *
     * @param user the user information to save
     * @return the user ID if successful, or -1 if failed
     */
    public Integer save(UserInfoDto user);

    /**
     * Deletes the user information from the database.
     *
     * @param userId the ID of the user to delete
     * @return true if the deletion succeeded, false otherwise
     */
    public Boolean delete(Integer userId);

    /**
     * Searches for a user based on a key and a type. The type determines which
     * field to search by: [0] --> ID [1] --> Full Name [2] --> Email
     *
     * @param key the value to search for (ID, full name, or email)
     * @param type the type of search (0 for ID, 1 for full name, 2 for email)
     * @return the matching UserInfoDto object, or null if not found
     */
    public UserInfoDto search(Object key, Integer type);

    /**
     * Retrieves a list of users filtered by their active status.
     *
     * @param active the activity status to filter users by: 1 for active users,
     * 0 for inactive users, or null to retrieve all users.
     * @return a list of {@link UserInfoDto} objects matching the specified
     * status, or an empty list if no users are found.
     */
    public List<UserInfoDto> listAll(Integer active);

    /**
     * used for login password 
     * @param email
     * @param password
     * @return null if the user Info are fake
     * otherwise retuns full userInfo
     */
    public  UserInfoDto authenticatUser(String email , String password);
}
