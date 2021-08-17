package com.niulipeng.returnJson;

/**
 * @Auther:niulipeng
 * @Date:2021/8/16
 * @Description:com.niulipeng.returnJson
 * @Version:1.0
 */
public class Permission {
    private String permissionId;

    public Permission(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId='" + permissionId + '\'' +
                '}';
    }
}
