package com.sossegopet.SossegoPetShop.exceptions;

public record StandardError(Integer status, String msg, Long timestamp) {
}
