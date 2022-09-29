package com.DAOBank;

import com.SessionFactoryProvider.SessionFactoryProvider;
import com.bean.CurrentAccount;
import com.bean.SavingAccount;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAOBankOperationImpl implements DAOBankOperation{
    long result;

    @Override
    public long registerCurrentAccount(CurrentAccount currentAccount) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        result = (long)session.save(currentAccount);
        session.beginTransaction().commit();
        return result;
    }

    @Override
    public long registerSavingAccount(SavingAccount savingAccount) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        result = (long)session.save(savingAccount);
        session.beginTransaction().commit();
        return result;
    }
}
