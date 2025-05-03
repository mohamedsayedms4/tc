/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ga.tc.common;

/**
 *
 * @author Mohamed Sayed
 */
public class Qyeries {

    // استعلام إدخال مستخدم جديد 
    public static String INSERT_NEW_USER =
    "INSERT INTO TC_USER (USR_FULL_NAME, USR_EMAIL, USR_PASSWORD, USR_PHONE, USR_ADDRESS, USR_ROLE, USR_ACTIVE, USR_LAF) " +
    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    // استعلام تحديث مستخدم موجود
    public static String UPDATE_USER =
        "UPDATE TC_USER SET USR_FULL_NAME=?, USR_EMAIL=?, USR_PASSWORD=?, USR_PHONE=?, USR_ADDRESS=?, USR_ROLE=?, USR_ACTIVE=?, USR_LAF=? WHERE USR_ID=?";
    
    // استعلام المصادقة
    public static String AUTHENTICATE_USER = 
        "SELECT USR_ID, USR_FULL_NAME, USR_PHONE, USR_ADDRESS, USR_ROLE, USR_LAF " +
        "FROM TC_USER WHERE USR_EMAIL = ? AND USR_PASSWORD=? AND USR_ACTIVE = 1";
    
    // استعلام حذف مستخدم
    public static String DELETE_USER = 
        "DELETE FROM TC_USER WHERE USR_ID = ?";
    
    // استعلام البحث عن مستخدم حسب المعرف
    public static String SEARCH_USER_BY_ID = 
        "SELECT * FROM TC_USER WHERE USR_ID = ?";
    
    // استعلام البحث عن مستخدم حسب الاسم الكامل
    public static String SEARCH_USER_BY_FULL_NAME = 
        "SELECT * FROM TC_USER WHERE USR_FULL_NAME LIKE ?";
    
    // استعلام البحث عن مستخدم حسب البريد الإلكتروني
    public static String SEARCH_USER_BY_EMAIL = 
        "SELECT * FROM TC_USER WHERE USR_EMAIL = ?";
    
    // استعلام قائمة المستخدمين النشطين
    public static String LIST_ACTIVE_USERS = 
        "SELECT * FROM TC_USER WHERE USR_ACTIVE = 1";
    
    // استعلام قائمة المستخدمين غير النشطين
    public static String LIST_INACTIVE_USERS = 
        "SELECT * FROM TC_USER WHERE USR_ACTIVE = 0";
    
    // استعلام قائمة جميع المستخدمين
    public static String LIST_ALL_USERS = 
        "SELECT * FROM TC_USER";
}
