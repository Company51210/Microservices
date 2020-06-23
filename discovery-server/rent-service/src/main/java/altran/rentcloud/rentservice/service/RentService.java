package altran.rentcloud.rentservice.service;

import altran.rentcloud.model.rent.Rent;
import altran.rentcloud.rentservice.model.DetailResponse;

import java.util.List;

public interface RentService {
    Rent save(Rent customer);

    Rent findById(int id);

    List<Rent> findAll();

    DetailResponse findDetailResponse(int id);
}
