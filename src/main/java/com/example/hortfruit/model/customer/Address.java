package com.example.hortfruit.model.customer;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class Address {

    @Id
    @Column(name = "id_endereco")
    private Long id;

    private String address;
    private String number;
    private String cep;
    private String city;
    private String state;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Customer customer;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
