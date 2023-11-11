package cz.upce.bvwa2.service;

import java.util.List;

public interface AbstractService<T> {

    T getOneByUuid(String uuid);
    List<T> getAll();

}
