package com.graphl.flight.graphql;

import lombok.Data;

import java.util.List;

@Data
public class InputAccomodation {
    private String id;
    private Number attention_number;
    private String imageUrl;
    private String owner;
    private String description;
    private String schedule;
    private String page;
    private Number quantity;
    private String description_services;
    private List<String> typeRoom;

}
