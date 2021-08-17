package com.niulipeng.returnJson;

import java.util.List;

/**
 * @Auther:niulipeng
 * @Date:2021/8/16
 * @Description:com.niulipeng.returnJson
 * @Version:1.0
 */
public class Permissions {
    private List<Permission> permissions;

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "permissions=" + permissions +
                '}';
    }
}
