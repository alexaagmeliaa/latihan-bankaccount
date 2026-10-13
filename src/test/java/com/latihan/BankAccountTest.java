package com.latihan;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private static final double DELTA = 0.001;

    @Test
    void saldoAwal_defaultNol() {
        BankAccount acc = new BankAccount();
        assertEquals(0, acc.getBalance(), DELTA);
    }

    @Test
    void saldoAwal_sesuaiParameter() {
        BankAccount acc = new BankAccount(100000);
        assertEquals(100000, acc.getBalance(), DELTA);
    }

    @Test
    void saldoAwal_negatif_throwException() {
        assertThrows(IllegalArgumentException.class,
            () -> new BankAccount(-1));
    }

    @Test
    void deposit_menambahSaldo() {
        BankAccount acc = new BankAccount(100000);
        acc.deposit(50000);
        assertEquals(150000, acc.getBalance(), DELTA);
    }

    @Test
    void deposit_nol_saldoTetap() {
        BankAccount acc = new BankAccount(100000);
        acc.deposit(0);
        assertEquals(100000, acc.getBalance(), DELTA);
    }

    @Test
    void deposit_negatif_throwException() {
        BankAccount acc = new BankAccount(100000);
        assertThrows(IllegalArgumentException.class,
            () -> acc.deposit(-5000));
        assertEquals(100000, acc.getBalance(), DELTA);
    }

    @Test
    void withdraw_mengurangiSaldo() {
        BankAccount acc = new BankAccount(100000);
        acc.withdraw(40000);
        assertEquals(60000, acc.getBalance(), DELTA);
    }

    @Test
    void withdraw_tepatSeluruhSaldo() {
        BankAccount acc = new BankAccount(100000);
        acc.withdraw(100000);
        assertEquals(0, acc.getBalance(), DELTA);
    }

    @Test
    void withdraw_melebihiSaldo_throwException() {
        BankAccount acc = new BankAccount(100000);
        assertThrows(IllegalArgumentException.class,
            () -> acc.withdraw(100001));
        assertEquals(100000, acc.getBalance(), DELTA);
    }

    @Test
    void withdraw_negatif_throwException() {
        BankAccount acc = new BankAccount(100000);
        assertThrows(IllegalArgumentException.class,
            () -> acc.withdraw(-1));
    }
}
