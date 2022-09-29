package com.DAOBank;

import com.bean.CurrentAccount;
import com.bean.SavingAccount;

public interface DAOBankOperation {
    long  registerCurrentAccount(CurrentAccount currentAccount);
    long registerSavingAccount(SavingAccount savingAccount);
}
