package com.management.role.dto;

import com.management.role.exception.RestApiResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * This class is an Entity model for message response
 */
@RequiredArgsConstructor
@Getter
@Setter
public class MessageResponse implements RestApiResponse {

    private String status;
    private int statusCode;
    private String code;
    private List<Message> messages;
}
