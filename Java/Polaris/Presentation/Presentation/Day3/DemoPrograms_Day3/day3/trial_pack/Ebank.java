package com.demoprograms.day3.trial_pack;

public interface Ebank
{

void Login(int AccNo, String Password);
void Balance();
void Transaction(int amount, String Password);

}
