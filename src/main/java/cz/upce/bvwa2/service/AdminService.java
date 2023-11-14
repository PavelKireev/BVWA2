package cz.upce.bvwa2.service;

import cz.upce.bvwa2.db.entity.Admin;
import cz.upce.bvwa2.model.admin.AdminCreateModel;
import cz.upce.bvwa2.model.admin.AdminModel;
import cz.upce.bvwa2.model.admin.AdminUpdateModel;

import java.util.List;

public interface AdminService extends AbstractService<AdminModel>{
    void create(AdminCreateModel adminModel);

    void delete(String uuid);

    void update(AdminUpdateModel adminModel);
}
