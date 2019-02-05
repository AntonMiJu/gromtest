package lesson35.controller;

import lesson35.service.OrderService;

public class OrderController {
    private OrderService orderService = new OrderService();

    public void cancelReservation(long roomId, long userId) {
        orderService.cancelReservation(roomId, userId);
    }

    public void bookRoom(long roomId, long userId,long hotelId){
        orderService.bookRoom(roomId,userId,hotelId);
    }
}
