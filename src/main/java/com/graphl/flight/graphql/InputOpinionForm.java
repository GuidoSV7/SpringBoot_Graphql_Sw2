package com.graphl.flight.graphql;

import lombok.Data;

@Data
public class InputOpinionForm {
    private String id;
    private Boolean state;
    private String origin;
    private String destination;
    private String accommodationName;
    private String tripOpinion;
    private String destinyOpinion;
    private String reasonTrip;
}
