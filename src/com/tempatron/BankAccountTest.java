package com.tempatron;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @org.junit.jupiter.api.BeforeEach
    public void setup() {
        account = new BankAccount("Abhi", "Raut", 1000.0, BankAccount.CHECKING);
        System.out.println("Running a test");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("This executes before any test cases and only once");
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        double balance = account.deposit(200, true);
        assertEquals(1200, balance, 0);

    }

    @org.junit.jupiter.api.Test
    void withDraw() {
        double balance = account.withDraw(600,true);
        assertEquals(400,balance,0);
    }

    @Test
    void withDraw_notBranch() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
        account.withDraw(600,false); //just checking if exceptions are throwns so we removed other bits of code
        });
    }




    @org.junit.jupiter.api.Test
    void getBalance_deposit() {

        account.deposit(200, true);
        assertEquals(1200, account.getBalance());

    }

    @org.junit.jupiter.api.Test
    void getBalance_branch() {

        account.deposit(600, false);
        assertEquals(1600, account.getBalance());

    }



    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {


        account.withDraw(100, true);
        assertEquals(900, account.getBalance());

    }

    @org.junit.jupiter.api.Test
    public void isCheckingTrue() {
        assertTrue(account.isChecking(), "The account is not checking account");

    }

    @AfterAll
    public static void afterAll(){
        System.out.println("This executes after all test cases");
    }

      /* @org.junit.jupiter.api.Test
    public void dummyTest(){
        assertEquals(20,20);
    }*/
}

