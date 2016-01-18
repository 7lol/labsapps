package databases.data;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Created by 7lol on 2016-01-14.
 */
public class DataForm {
    @Size(min=2, max=30)
    private String name;

    @Size(min=2, max=30)
    private String surname;
    @Size(min=2, max=30)
    private String city;
    @Size(min=2, max=30)
    private String country;
    @Size(min=11, max=11)
    private String pesel;
    boolean male;
    @NotNull
    @Min(18)

    public String getSex() {
        if (male) return "MAN";
        else return "WOMAN";
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String toString() {
        return pesel+";"+getSex()+";"+name+";"+surname+";"+city+";"+country;
    }
}
