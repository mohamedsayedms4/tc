/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ga.tc.authentication.dto;

import java.util.Objects;

/**
 *
 * @author Mohamed Sayed
 */
public class UserInfoDto {
    private int userId , roleId ,active ;
    private String fullName , email , password , phones , laf , address ;
    
    public UserInfoDto()
    {
        
    }
    
    public UserInfoDto(int userId, int roleId, int active, String fullName, String email, String password, String phones, String laf, String address) {
        this.userId = userId;
        this.roleId = roleId;
        this.active = active;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.laf = laf;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getLaf() {
        return laf;
    }

    public void setLaf(String laf) {
        this.laf = laf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.userId;
        hash = 59 * hash + this.roleId;
        hash = 59 * hash + this.active;
        hash = 59 * hash + Objects.hashCode(this.fullName);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.password);
        hash = 59 * hash + Objects.hashCode(this.phones);
        hash = 59 * hash + Objects.hashCode(this.laf);
        hash = 59 * hash + Objects.hashCode(this.address);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserInfoDto other = (UserInfoDto) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.roleId != other.roleId) {
            return false;
        }
        if (this.active != other.active) {
            return false;
        }
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.phones, other.phones)) {
            return false;
        }
        if (!Objects.equals(this.laf, other.laf)) {
            return false;
        }
        return Objects.equals(this.address, other.address);
    }

    @Override
    public String toString() {
        return "UserInfoDto{" + "userId=" + userId + ", roleId=" + roleId + ", active=" + active + ", fullName=" + fullName + ", email=" + email + ", password=" + password + ", phones=" + phones + ", laf=" + laf + ", address=" + address + '}';
    }
    
    
}
