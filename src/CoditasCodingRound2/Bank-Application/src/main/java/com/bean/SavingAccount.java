package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class SavingAccount implements Bank {
    @Id@Column(name = "ACCOUNT_NO")
    private long accountNO;
    @Column(name = "ACCOUNT_HOLDER_NAME")
    private String accountHolderName;

    @Column(name = "CONTACT")
    private String contact;
    @Column(name = "BALANCE")
    private float balance;
    @OneToMany
    private List<Address> address;

    @Override
    public String toString() {
        return "SavingAccount{" +
                "accountNO=" + accountNO +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", contact='" + contact + '\'' +
                ", balance=" + balance +
                ", address=" + address +
                '}';
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    public long getAccountNO() {
        return accountNO;
    }

    public void setAccountNO(long accountNO) {
        this.accountNO = accountNO;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
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
}
