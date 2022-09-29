package com.bean;

import javax.persistence.*;
import java.util.List;
@Entity
public class CurrentAccount implements Bank{
    @Id
    @Column(name = "ACCOUNT_NO")
    private long accountNO;



    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Column(name = "CONTACT")
    private String contact;

    @Column(name = "BALANCE")
    private float balance;
    @Column(name = "ACCOUNT_HOLDER_NAME")
    private String accountHolderName;
    @OneToMany
    private List<Address> address;

    public long getAccountNO() {
        return accountNO;
    }

    public void setAccountNO(long accountNO) {
        this.accountNO = accountNO;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    @Override
    public String toString() {
        return "CurrentAccount{" +
                "accountNO=" + accountNO +
                ", contact='" + contact + '\'' +
                ", balance=" + balance +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", address=" + address +
                '}';
    }

}
