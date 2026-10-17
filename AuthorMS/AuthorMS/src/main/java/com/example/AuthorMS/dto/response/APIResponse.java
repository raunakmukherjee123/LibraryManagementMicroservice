package com.example.AuthorMS.dto.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@Builder
public class APIResponse<T> {
  private Instant timestamp;

  private Integer status;

  private HttpStatus code;

  private boolean success;

  private String message;

  private T data;
}
