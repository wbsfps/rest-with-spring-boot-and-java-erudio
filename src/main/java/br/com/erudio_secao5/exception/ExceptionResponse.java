package br.com.erudio_secao5.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}