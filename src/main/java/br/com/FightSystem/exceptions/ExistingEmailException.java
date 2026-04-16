package br.com.FightSystem.exceptions;

public class ExistingEmailException extends RuntimeException {
    public ExistingEmailException(String message) {
        super(message);
    }
}
