package com.game.gamewarmup.deque;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node<T> {
    private T value;
    private Node<T> prev;
    private Node<T> next;
}