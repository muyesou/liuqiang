package com.example.demo.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Node {
    int value;
    Node next;
    Node(int value){
        this.value=value;
    }
}
