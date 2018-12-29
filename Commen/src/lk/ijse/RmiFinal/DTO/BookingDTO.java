package lk.ijse.RmiFinal.DTO;

import java.io.Serializable;

public class BookingDTO  implements Serializable {
    private CustomerDTO customerDTO;
    private TicatDTO ticatDTO;
    private String newId;

    public BookingDTO(CustomerDTO customerDTO, TicatDTO ticatDTO, String newId) {
        this.customerDTO = customerDTO;
        this.ticatDTO = ticatDTO;
        this.newId = newId;
    }

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }

    public BookingDTO() {
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public TicatDTO getTicatDTO() {
        return ticatDTO;
    }

    public void setTicatDTO(TicatDTO ticatDTO) {
        this.ticatDTO = ticatDTO;
    }
}
