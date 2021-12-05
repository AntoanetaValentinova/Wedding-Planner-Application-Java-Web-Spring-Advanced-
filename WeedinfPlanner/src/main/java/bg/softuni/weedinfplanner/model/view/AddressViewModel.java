package bg.softuni.weedinfplanner.model.view;

public class AddressViewModel {
    private String address;
    private String cityName;

    public AddressViewModel() {
    }

    public String getAddress() {
        return address;
    }

    public AddressViewModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public AddressViewModel setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }
}
