package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.projection.UnpaidDetails;

import java.util.List;

public interface ReservationBO extends SuperBO<ReservationDTO, String> {
    String generateID();

    List<UnpaidDetails> getUnpaidDetails();
}
