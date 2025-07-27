package constant;

public class SessionManager {
   
    private static int userId;
    private static int roleId;
    private static String userName;
    private static String name;

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        SessionManager.userId = userId;
    }

    public static int getRoleId() {
        return roleId;
    }

    public static void setRoleId(int roleId) {
        SessionManager.roleId = roleId;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        SessionManager.userName = userName;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        SessionManager.name = name;
    }
}