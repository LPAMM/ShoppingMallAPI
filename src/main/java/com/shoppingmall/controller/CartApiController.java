package com.shoppingmall.controller;

import com.shoppingmall.entity.Cart;
import com.shoppingmall.security.jwt.util.IfLogin;
import com.shoppingmall.security.jwt.util.LoginUserDto;
import com.shoppingmall.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartApiController {
    private final CartService cartService;
    @PostMapping
    public Cart addCart(@IfLogin LoginUserDto loginUserDto) {
        LocalDate localDate = LocalDate.now();
        localDate.getYear();
        localDate.getDayOfMonth();
        localDate.getMonthValue();
        String date = String.valueOf(localDate.getYear()) + (localDate.getMonthValue() < 10 ? "0" :"") + String.valueOf(localDate.getMonthValue()) + (localDate.getDayOfMonth() < 10 ? "0" :"") +String.valueOf(localDate.getDayOfMonth());
        Cart cart = cartService.addCart(loginUserDto.getMemberId(), date);
        return cart;
    }


}